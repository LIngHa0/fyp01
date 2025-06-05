package com.example.venuebooking.service.impl;

import com.example.venuebooking.entity.User;
import com.example.venuebooking.repository.UserRepository;
import com.example.venuebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service/impl/UserServiceImpl.java
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User register(User user) {
        // 简单判断用户名是否存在
        if(userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        // 这里密码最好做加密，先简单存明文
        return userRepo.save(user);
    }


    @Override
    public User login(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }
}
