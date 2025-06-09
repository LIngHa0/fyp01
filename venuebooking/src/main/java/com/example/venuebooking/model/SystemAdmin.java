package com.example.venuebooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("system_admin")  // 对应数据库表名
public class SystemAdmin implements Serializable {

    @TableId(type = IdType.AUTO)
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
