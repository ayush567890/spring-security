package com.ayush.spring_security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class usercontroller {
    @GetMapping("/profile")
    public String profile(){
        return "Welcome USER";
    }

}
