package com.example.venuebooking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.venuebooking.model.SystemAdmin;
import com.example.venuebooking.request.SystemAdminLoginRequest;
import com.example.venuebooking.response.SystemLoginResponse;

public interface AdminLoginService  extends IService<SystemAdmin> {

    SystemLoginResponse login(SystemAdminLoginRequest request);

}
