package com.raj.DataBaseOneOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    Iterable<User> findAllUsers() {
        Iterable<User> userIterator;
        userIterator = userRepository.findAll();
        return userIterator;

    }
}
