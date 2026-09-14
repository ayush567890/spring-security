package com.ayush.spring_security.security;

import com.ayush.spring_security.dto.register_request;
import com.ayush.spring_security.entity.User;
import com.ayush.spring_security.repository.User_repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    private final User_repository userrepository;
    private final PasswordEncoder passwordencoder;

    public Userservice(User_repository userrepository, PasswordEncoder passwordencoder){
        this.passwordencoder=passwordencoder;
        this.userrepository=userrepository;
    }

    public void register(register_request request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordencoder.encode(request.getPassword()));
        user.setRole("USER");

        userrepository.save(user);
    }
}
