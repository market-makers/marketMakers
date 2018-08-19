package com.marketMakers.resource;

import com.marketMakers.model.Invoice;
import com.marketMakers.model.Product;
import com.marketMakers.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class InvoiceResource {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "/user/{userId}/invoice", method = RequestMethod.POST)
    public ResponseEntity save(@PathVariable String userId, Map<String, Object> body) {
        try {
            //System.out.printf(body.get("invoiceId").toString());
            Iterable<Invoice> result = invoiceService.findAll();
            return new ResponseEntity<>(result.iterator().next(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void getProdutsOnThefederalIncome() {
        Product product = new Product();
    }}