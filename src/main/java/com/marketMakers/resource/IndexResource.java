package com.marketMakers.resource;

import com.marketMakers.model.User;
import com.marketMakers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class IndexResource {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity home() {
        return new ResponseEntity<>("Keep working XD", HttpStatus.OK);
    }
}