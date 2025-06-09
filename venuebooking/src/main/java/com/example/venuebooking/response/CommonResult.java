package com.example.venuebooking.response;

import com.example.venuebooking.exception.ExceptionCodeEnum;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {
    private long code;
    private String message;
    private T data;

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(), message, data);
    }
    public static <T> CommonResult<T> success(String message) {
        return new CommonResult<T>(ExceptionCodeEnum.SUCCESS.getCode(), message, null);
    }
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ExceptionCodeEnum.FAILED.getCode(), message, null);
    }

}
