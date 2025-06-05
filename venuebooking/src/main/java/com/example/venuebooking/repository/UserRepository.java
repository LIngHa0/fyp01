package com.example.venuebooking.repository;

import com.example.venuebooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// repository/UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
