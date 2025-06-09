package com.example.venuebooking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.venuebooking.model.SystemAdmin;
import com.example.venuebooking.request.SystemAdminAddRequest;

public interface SystemAdminService extends IService<SystemAdmin> {
    Boolean saveAdmin(SystemAdminAddRequest systemAdminAddRequest);

}
