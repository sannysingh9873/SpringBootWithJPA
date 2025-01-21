package com.jpa.example.SpringBootWithJPA.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ProfileController")
public class ProfileController {


    @Value("${my.website.name}")
    private String myWebsiteName;


    @GetMapping(path = "/profile")
    public String welcome() {
        return "Welcome to " + myWebsiteName;
    }
}
