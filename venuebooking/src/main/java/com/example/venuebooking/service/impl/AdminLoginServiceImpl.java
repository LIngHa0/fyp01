package com.example.venuebooking.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.venuebooking.exception.CrmebException;
import com.example.venuebooking.exception.ExceptionCodeEnum;
import com.example.venuebooking.mapper.SystemAdminMapper;
import com.example.venuebooking.model.SystemAdmin;
import com.example.venuebooking.request.SystemAdminLoginRequest;
import com.example.venuebooking.response.SystemLoginResponse;
import com.example.venuebooking.service.AdminLoginService;
import com.example.venuebooking.service.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class AdminLoginServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements AdminLoginService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public SystemLoginResponse login(SystemAdminLoginRequest request) {

        SystemAdmin admin = adminLoginService.getOne(
                new QueryWrapper<SystemAdmin>().eq("email", request.getEmail())
        );

        //这里你自己尝试加检查admin status然后用crmeb丢出来
        //todo
        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new CrmebException(ExceptionCodeEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }

        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("TOKEN:" + token, JSON.toJSONString(admin), 30, TimeUnit.MINUTES);

        SystemLoginResponse systemAdminResponse = new SystemLoginResponse();
        BeanUtils.copyProperties(admin, systemAdminResponse);

        return systemAdminResponse;
    }
}
