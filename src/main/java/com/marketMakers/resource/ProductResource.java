package com.marketMakers.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketMakers.dto.Category;
import com.marketMakers.model.Product;
import com.marketMakers.service.ProductService;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            Iterable<Product> result = productService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@RequestMapping(value = "/product/best-sellers", method = RequestMethod.GET)
    public ResponseEntity<?> findAllLimit(@RequestParam("limit") String quantity) {
        try {
        	List<Product> result = productService.findAllLimit(Integer.parseInt(quantity));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@RequestMapping(value = "/product/missing", method = RequestMethod.GET)
    public ResponseEntity<?> findAllMissingLimit(@RequestParam("limit") String quantity) {
        try {
        	List<Product> result = productService.findAllMissingLimit(Integer.parseInt(quantity));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@RequestMapping(value = "/category/best-sellers", method = RequestMethod.GET)
    public ResponseEntity<?> findAllCategoryLimit(@RequestParam("limit") String quantity) {
        try {
        	List<Category> result = productService.findAllCategoryLimit(Integer.valueOf(quantity));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
