package com.ing.Soft.controllers;

import com.ing.Soft.entities.User;
import com.ing.Soft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    
    @GetMapping("/id")
    public Optional<User> findById(@RequestParam Integer id){
        return userService.findById(id);
    }

    @GetMapping("/username")
    public Integer getUsername(Principal principal){
        return userService.getIdByUsername(principal.getName());
    }


}


