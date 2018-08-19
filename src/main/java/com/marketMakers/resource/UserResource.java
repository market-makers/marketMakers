package com.marketMakers.resource;

import com.marketMakers.model.User;
import com.marketMakers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Map<String, Object> body) {
        try {
            User user = new User(
                    body.get("id").toString(),
                    body.get("name").toString(),
                    body.get("email").toString());
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}