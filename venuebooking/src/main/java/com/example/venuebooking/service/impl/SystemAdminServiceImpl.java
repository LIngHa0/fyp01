package com.example.venuebooking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.venuebooking.exception.CrmebException;
import com.example.venuebooking.exception.ExceptionCodeEnum;
import com.example.venuebooking.mapper.SystemAdminMapper;
import com.example.venuebooking.model.SystemAdmin;
import com.example.venuebooking.request.SystemAdminAddRequest;
import com.example.venuebooking.service.SystemAdminService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {

    @Resource
    private SystemAdminMapper dao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Boolean saveAdmin(SystemAdminAddRequest request) {
        // 管理员名称唯一校验
        Integer result = checkEmail(request.getEmail());
        if (result > 0) {
            throw new CrmebException(ExceptionCodeEnum.EMAIL_EXISTED);
        }

        SystemAdmin systemAdmin = new SystemAdmin();
        BeanUtils.copyProperties(request, systemAdmin);
        systemAdmin.setPassword(passwordEncoder.encode(request.getPassword()));
        return save(systemAdmin);
    }

    private Integer checkEmail(String email) {
        LambdaQueryWrapper<SystemAdmin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SystemAdmin::getEmail, email);
        return dao.selectCount(lambdaQueryWrapper);
    }

}
