package com.marketMakers.service;

import com.marketMakers.model.Company;
import com.marketMakers.model.Usuario;
import com.marketMakers.repository.CompanyRepository;
import com.marketMakers.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public Iterable<Company> findAll() {
        return repository.findAll();
    }

    public Company save(Company company) {
        return repository.save(company);
    }
}