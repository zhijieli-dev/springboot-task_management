package com.example.utils;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result() {}

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Customer code and message + data
    public static <T> Result<T> build(Integer code, String message, T data) {
        return new Result<T>(code, message, data);
    }

    // Use ResultCodeEnum
    public static <T> Result<T> build(ResultCodeEnum resultCodeEnum, T data) {
        return new Result<T>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

    // Success
    public static <T> Result<T> ok(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

}
