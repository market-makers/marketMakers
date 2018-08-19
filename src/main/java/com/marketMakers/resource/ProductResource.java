package com.marketMakers.resource;

import com.marketMakers.model.Product;
import com.marketMakers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/produto/{clientId}", method = RequestMethod.GET)
    public ResponseEntity find(@PathVariable String clientId) {
        try {
            Iterable<Product> result = productService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}