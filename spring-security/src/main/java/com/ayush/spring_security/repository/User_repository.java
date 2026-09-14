package com.ayush.spring_security.repository;

import com.ayush.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_repository extends JpaRepository<User,Long> {
}
