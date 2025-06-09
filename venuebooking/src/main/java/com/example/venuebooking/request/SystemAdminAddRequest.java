package com.example.venuebooking.request;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("system_admin")  // 对应数据库表名
public class SystemAdminAddRequest {

    private String uuid;
    //email
    @NotNull(message = "后台管理员账号不能为空")
    @Length(max = 32, message = "账号长度不能超过32个字符")
    private String email;

    @NotNull(message = "管理员密码不能为空")
    @Length(max = 32, message = "密码长度不能超过32个字符")
    private String password;

    @NotNull(message = "管理姓名不能为空")
    private String realName;

    @NotNull(message = "后台管理员角色不能为空")
    private String roles;

    //后台管理员状态 1有效0无效
    @NotNull(message = "status 字段不能为空")
    @Range(min = 0, max = 1, message = "未知的状态")
    private Boolean status;


}
