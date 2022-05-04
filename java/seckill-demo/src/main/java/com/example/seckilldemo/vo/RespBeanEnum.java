package com.example.seckilldemo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum RespBeanEnum {

    SUCCESS(200,"SUCCESS"),
    ERROR(500,"SERVER ERR"),

    LOGINERR(500210,"USER LOGIN ERR"),
    MOBILEERR(500211,"MOBILE LOGIN ERR"),
    BDINGEERR(500212,"BIND  ERR");
    private final Integer code;
    private final String message;
}
