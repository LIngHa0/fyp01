package com.example.venuebooking.service;

import com.alibaba.fastjson.JSON;
import com.example.venuebooking.model.SystemAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class TokenService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void saveToken(String token, SystemAdmin user) {
        // 将用户对象转为 JSON 字符串
        String json = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("TOKEN:" + token, json, Duration.ofMinutes(30));
    }

    public SystemAdmin getUserByToken(String token) {
        String json = redisTemplate.opsForValue().get("TOKEN:" + token);
        return JSON.parseObject(json, SystemAdmin.class);
    }



}
