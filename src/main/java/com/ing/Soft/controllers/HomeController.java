package com.ing.Soft.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Default redirect if the user has no matching role
        return "redirect:/kurset.html";
    }
}

