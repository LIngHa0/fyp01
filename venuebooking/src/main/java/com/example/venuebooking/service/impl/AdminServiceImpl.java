package com.example.venuebooking.service.impl;

import com.example.venuebooking.entity.Admin;
import com.example.venuebooking.repository.AdminRepository;
import com.example.venuebooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service/impl/AdminServiceImpl.java
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin login(String username, String password) {
        return adminRepository.findByUsername(username)
                .filter(admin -> admin.getPassword().equals(password))
                .orElse(null);
    }
}
