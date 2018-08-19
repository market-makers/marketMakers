package com.marketMakers.repository;

import com.marketMakers.model.User;
import org.springframework.data.repository.CrudRepository;

import com.marketMakers.model.User;

public interface UserRepository extends CrudRepository<User, String> {
}
