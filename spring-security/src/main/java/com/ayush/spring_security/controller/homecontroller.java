package com.ayush.spring_security.controller;


import com.ayush.spring_security.dto.register_request;
import com.ayush.spring_security.entity.User;
import com.ayush.spring_security.repository.User_repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontroller{
    private final User_repository userrepository;
    private final PasswordEncoder passwordencoder;

    public homecontroller(User_repository userrepository,PasswordEncoder passwordencoder){
        this.userrepository=userrepository;
        this.passwordencoder=passwordencoder;
    }


    @PostMapping("/register")
    public String register(@RequestBody register_request request){
        User user = User.builder().name(request.getName()).email(request.getEmail()).password(passwordencoder.encode(request.getPassword())).build();

        userrepository.save(user);

        return "User registered successfully";
    }

}
