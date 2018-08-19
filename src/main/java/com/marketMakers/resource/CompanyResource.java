package com.marketMakers.resource;

import com.marketMakers.model.Company;
import com.marketMakers.service.AddressService;
import com.marketMakers.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Company company) {
        try {
            addressService.save(company.getAddress());
            company.setPartner(true);
            companyService.save(company);
            company.setPassword("");
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/company/login", method = RequestMethod.POST)
    public ResponseEntity getCompany(@RequestBody Map<String, Object> body) {
        try {
            String email = body.get("email").toString();
            String password = body.get("password").toString();
            Company company = companyService.findByEmailAndPassword(email, password);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}