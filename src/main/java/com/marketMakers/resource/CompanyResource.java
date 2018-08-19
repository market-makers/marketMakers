package com.marketMakers.resource;

import com.marketMakers.model.Company;
import com.marketMakers.model.Usuario;
import com.marketMakers.service.CompanyService;
import com.marketMakers.service.UsuarioService;
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

    @RequestMapping(value = "/api/company", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Company company) {
        try {
            companyService.save(company);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}