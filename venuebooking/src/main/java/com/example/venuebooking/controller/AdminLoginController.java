package com.example.venuebooking.controller;

import com.example.venuebooking.exception.CrmebException;
import com.example.venuebooking.exception.ExceptionCodeEnum;
import com.example.venuebooking.request.SystemAdminAddRequest;
import com.example.venuebooking.request.SystemAdminLoginRequest;
import com.example.venuebooking.response.CommonResult;
import com.example.venuebooking.response.SystemLoginResponse;
import com.example.venuebooking.service.AdminLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// controller/admin/AdminController.java
@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminLoginController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AdminLoginService adminLoginService;


    @PostMapping(value = "/login", produces = "application/json")
    public CommonResult<SystemLoginResponse> SystemAdminLogin(@RequestBody @Validated SystemAdminLoginRequest systemAdminLoginRequest, HttpServletRequest request) {
        SystemLoginResponse systemAdminResponse = adminLoginService.login(systemAdminLoginRequest);
        return CommonResult.success(systemAdminResponse, "login success");
    }

    @PostMapping(value = "/logout", produces = "application/json")
    public CommonResult<String> SystemAdminLogout(HttpServletRequest request) {
        // 获取当前用户的 token
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            throw new CrmebException(ExceptionCodeEnum.TOKEN_NOT_EXIST);
        }
        // 移除 Redis 中的 token
        redisTemplate.delete("TOKEN:" + token);

        return CommonResult.success("Logout success");
    }
}
