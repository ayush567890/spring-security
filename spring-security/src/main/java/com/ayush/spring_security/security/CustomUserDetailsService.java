package com.ayush.spring_security.security;

import com.ayush.spring_security.entity.User;
import com.ayush.spring_security.repository.User_repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final User_repository userrepository;

    public CustomUserDetailsService(User_repository userrepository){
        this.userrepository=userrepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
        User user = userrepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities(user.getRole()).build();

    }

}
