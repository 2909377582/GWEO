package com.example.gweo_sb.controller;

import com.example.gweo_sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Usercontroller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/receiveData")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}

