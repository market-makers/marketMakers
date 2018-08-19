package com.marketMakers.resource;

import com.marketMakers.model.Address;
import com.marketMakers.model.User;
import com.marketMakers.repository.AddressRepository;
import com.marketMakers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class IndexResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity home() {
        return new ResponseEntity<>("Keep working XD", HttpStatus.OK);
    }

    @RequestMapping(value = "/create-data", method = RequestMethod.GET)
    public ResponseEntity createData() {
        User user = new User("XP532", "Gustavo", "gustavocarvalho_ti@hotmail.com", 0);
        userRepository.save(user);

        Address address = new Address(
                "Rua Bogota 51",
                "Recanto dos Sonhos",
                "Sumaré",
                "SP",
                "13178-899",
                "Casa");
        addressRepository.save(address);

        return new ResponseEntity<>("Created was successfully!", HttpStatus.OK);
    }
}