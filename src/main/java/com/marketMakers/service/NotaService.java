package com.marketMakers.service;

import com.marketMakers.model.Nota;
import com.marketMakers.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    NotaRepository repository;

    public Iterable<Nota> findAll() {
        return repository.findAll();
    }
}