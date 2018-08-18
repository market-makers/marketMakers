package com.marketMakers.resource;

import com.marketMakers.model.Produto;
import com.marketMakers.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produto/{clientId}", method = RequestMethod.GET)
    public ResponseEntity find() {
        try {
            Iterable<Produto> result = produtoService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}