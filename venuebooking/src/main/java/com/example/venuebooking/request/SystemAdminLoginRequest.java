package com.example.venuebooking.request;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class SystemAdminLoginRequest {
    @NotEmpty(message = "账号 不能为空")
    @Length(max = 32, message = "账号长度不能超过32个字符")
    private String email;

    @NotEmpty(message = "密码 不能为空")
    @Length(min = 6, max = 30 ,message = "密码长度在6-30个字符")
    private String password;
}
