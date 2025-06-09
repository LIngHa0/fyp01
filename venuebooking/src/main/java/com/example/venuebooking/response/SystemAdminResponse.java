package com.example.venuebooking.response;

import lombok.Data;

import java.util.Date;

@Data
public class SystemAdminResponse {
    private Integer id;

    //email
    private String email;

    private String password;

    private String realName;

    private String roles;

    //后台管理员最后一次登录时间
    private Date updateTime;

    //后台管理员添加时间
    private Date createTime;

    //后台管理员状态 1有效0无效
    private Boolean status;

}
