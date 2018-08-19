package com.marketMakers.service;

import com.marketMakers.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Iterable<Category> findAll() {
        return repository.findAll();
    }
}