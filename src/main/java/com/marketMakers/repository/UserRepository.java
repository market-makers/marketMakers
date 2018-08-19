package com.marketMakers.repository;

import com.marketMakers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
