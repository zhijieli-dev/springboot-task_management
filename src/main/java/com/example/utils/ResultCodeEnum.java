package com.example.utils;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    NOT_FIND(404, "not find"),
    SUCCESS(200, "success");

    private final Integer code;
    private final String message;

     ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
