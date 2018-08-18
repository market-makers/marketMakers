package com.marketMakers.service;

import com.marketMakers.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Nota;
import com.marketMakers.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Iterable<Categoria> findAll() {
        return repository.findAll();
    }
}