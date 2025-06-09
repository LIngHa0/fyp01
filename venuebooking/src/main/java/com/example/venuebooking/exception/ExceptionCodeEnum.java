package com.example.venuebooking.exception;

public enum ExceptionCodeEnum implements ExceptionHandler {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),





    ACCOUNT_OR_PASSWORD_ERROR(2000, "账号或密码错误"),
    TOKEN_NOT_EXIST(2001, "Token为空"),
    EMAIL_EXISTED(2002, "该email已经是管理员");



    private long code;
    private String message;

    private ExceptionCodeEnum(long code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
