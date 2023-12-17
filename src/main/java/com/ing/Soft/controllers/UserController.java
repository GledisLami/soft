package com.ing.Soft.controllers;

import com.ing.Soft.entities.User;
import com.ing.Soft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/id")
    public Optional<User> findById(@RequestParam Long id){
        return userService.findById(id);
    }
}
