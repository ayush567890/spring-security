package com.ayush.spring_security.controller;


import com.ayush.spring_security.entity.User;
import com.ayush.spring_security.repository.User_repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontroller{
    private final User_repository userrepository;

    public homecontroller(User_repository userrepository){
        this.userrepository=userrepository;
    }

    @PostMapping("/save")
    public String saveuser(){
        User user = User.builder().name("Ayush").email("ayush123@gmail.com").password("123456").build();

        userrepository.save(user);

        return "User is saved in the database";
    }


}
