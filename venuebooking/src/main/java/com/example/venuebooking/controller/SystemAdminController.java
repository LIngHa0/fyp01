package com.example.venuebooking.controller;

import com.example.venuebooking.request.SystemAdminAddRequest;
import com.example.venuebooking.response.CommonResult;
import com.example.venuebooking.response.SystemAdminResponse;
import com.example.venuebooking.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;


    @PostMapping("/save")
    public CommonResult<SystemAdminResponse> save(@RequestBody SystemAdminAddRequest request) {
        if (systemAdminService.saveAdmin(request)) {
            return CommonResult.success("添加管理员成功");
        }
        return CommonResult.failed("添加管理员失败");
    }
}
