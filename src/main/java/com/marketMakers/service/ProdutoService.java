package com.marketMakers.service;

import com.marketMakers.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Nota;
import com.marketMakers.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Iterable<Produto> findAll() {
        return repository.findAll();
    }
}