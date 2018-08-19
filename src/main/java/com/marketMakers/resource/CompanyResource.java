package com.marketMakers.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketMakers.model.Company;
import com.marketMakers.service.CompanyService;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Company company) {
        try {
            companyService.save(company);
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