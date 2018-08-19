package com.marketMakers.resource;

import com.marketMakers.model.Company;
import com.marketMakers.model.Promotion;
import com.marketMakers.service.CompanyService;
import com.marketMakers.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@CrossOrigin(maxAge = 3600)
@RestController
public class PromotionResource {

    @Autowired
    private PromotionService promotionService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/promotion", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            Iterable<Promotion> result = promotionService.getAllPromotions();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        try {
            Promotion result = promotionService.getPromotion(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/promotion", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Promotion promotion) {
        try {
            Company company = companyService.findByNameLike("Mike Supermercados");
            if (company != null) {
                Timestamp data = new Timestamp(new Date().getTime());

                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                cal.add(Calendar.DAY_OF_WEEK, 10);

                promotion.setExpiration(new Timestamp(cal.getTime().getTime()));
                promotion.setCompany(company);
                promotion = promotionService.save(promotion);
                return new ResponseEntity<>(promotion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Promotion promocao) {
        try {
            Promotion result = promotionService.updatePromotion(id, promocao);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            promotionService.deletePromotion(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}