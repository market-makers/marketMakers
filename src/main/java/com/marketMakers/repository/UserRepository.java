package com.marketMakers.repository;

import org.springframework.data.repository.CrudRepository;

import com.marketMakers.model.User;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUserApp(String userApp);
}
