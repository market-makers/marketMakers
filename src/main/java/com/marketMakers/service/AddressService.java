package com.marketMakers.service;

import com.marketMakers.model.Address;
import com.marketMakers.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public Address save(Address address) {
        return repository.save(address);
    }
}