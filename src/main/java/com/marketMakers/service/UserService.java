package com.marketMakers.service;

import com.marketMakers.model.User;
import com.marketMakers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User getUser(String id) {
        return repository.findOne(id);
    }

    public User findByUserApp(String userApp) {
        return repository.findByUserApp(userApp);
    }
}