package com.example.venuebooking.service;

import com.example.venuebooking.entity.User;

// service/UserService.java
public interface UserService {
    User register(User user);
    User login(String username, String password);
}
