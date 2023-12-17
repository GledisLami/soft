package com.ing.Soft.controllers;
import com.ing.Soft.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public void saveUser(@RequestParam String name){

    }
}

