package com.marketMakers.repository;

import com.marketMakers.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByEmailAndPassword(String email, String passwor);

    Company findByNameLike(String name);
}