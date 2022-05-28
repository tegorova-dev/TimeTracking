package com.example.timetracking.Liquibase.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public enum ErrorDescription {
    UNKNOWN_ERROR("unknown_error","При выполнении запроса возникла неизвестная ошибка", 500),
    CANNOT_GET_PARTNERS("cannot_get_partners","При получении списка партнеров возникла неизвестная ошибка", 500),

    JSON_PARSE_ERROR("JSON_parse_error","При получении списка партнеров возникла неизвестная ошибка", 415);


    private String code;
    private String text;
    private int status;
}
