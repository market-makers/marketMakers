package com.marketMakers.service;

import com.marketMakers.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Iterable<Product> findAll() {
        return repository.findAll();
    }
}