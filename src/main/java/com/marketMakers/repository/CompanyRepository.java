package com.marketMakers.repository;

import org.springframework.data.repository.CrudRepository;

import com.marketMakers.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	
}
