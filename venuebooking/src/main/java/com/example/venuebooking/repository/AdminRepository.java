package com.example.venuebooking.repository;

import com.example.venuebooking.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// repository/AdminRepository.java
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
