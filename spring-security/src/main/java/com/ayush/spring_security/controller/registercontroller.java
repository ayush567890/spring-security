package com.ayush.spring_security.controller;


import com.ayush.spring_security.dto.register_request;
import com.ayush.spring_security.security.Userservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registercontroller {
    private final Userservice userservice;

    public registercontroller(Userservice userservice){
        this.userservice=userservice;
    }

    @PostMapping("/register")
    public String register(@RequestBody register_request request){
        userservice.register(request);

        return "User is registered successfully";
    }

    @GetMapping("/")
    public String home() {
        return "Login Success";
    }
}
