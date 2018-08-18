package com.marketMakers.resource;

import com.marketMakers.model.Nota;
import com.marketMakers.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class NotaResource {

    @Autowired
    private NotaService notaService;

    @RequestMapping(value = "/teste/nota/all", method = RequestMethod.GET)
    public ResponseEntity find() {
        try {
            Iterable<Nota> result = notaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}