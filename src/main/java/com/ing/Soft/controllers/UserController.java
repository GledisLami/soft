package com.ing.Soft.controllers;
import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.User;
import com.ing.Soft.services.CourseService;
import com.ing.Soft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
}

