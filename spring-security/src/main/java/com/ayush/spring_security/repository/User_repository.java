package com.ayush.spring_security.repository;

import com.ayush.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface User_repository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);
}
