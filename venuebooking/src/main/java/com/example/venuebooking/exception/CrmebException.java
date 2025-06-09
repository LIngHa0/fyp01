package com.example.venuebooking.exception;

public class CrmebException extends RuntimeException  {
    private long code;
    private String message;

    // 构造函数
    public CrmebException(ExceptionCodeEnum exceptionCodeEnum) {
        this.code = exceptionCodeEnum.getCode();
        this.message = exceptionCodeEnum.getMessage();
    }

    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
