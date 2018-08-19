package com.marketMakers.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketMakers.model.Company;
import com.marketMakers.model.Promotion;
import com.marketMakers.service.PromotionService;

@CrossOrigin(maxAge = 3600)
@RestController
public class PromotionResource {

    @Autowired
    private PromotionService promotionService;

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
    public ResponseEntity<?> save(@RequestBody Map<String, Object> body) {
        try {
		 	Company company = promotionService.findCompany(body.get("companyId").toString());
		 	if (company != null) {
		 		String value = (body.get("value").toString());
		 		String coupons = (body.get("coupons").toString());
		 		String exDate = (body.get("exDate").toString());
		 		
		 		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		 		Date date = (Date)formatter.parse(exDate);
		 		
		 		Promotion promotion = new Promotion(body.get("description").toString(), Double.valueOf(value), 
		 											body.get("type").toString(), company, Long.valueOf(coupons), body.get("title").toString(), date); 
		 		promotion = promotionService.save(promotion);
		 		return new ResponseEntity<>(promotion, HttpStatus.OK);
			}else {
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
