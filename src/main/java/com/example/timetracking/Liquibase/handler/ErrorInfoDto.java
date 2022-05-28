package com.example.timetracking.Liquibase.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfoDto {
    private String code;
    private String text;

    public ErrorInfoDto(String text) {
        this.text = text;
    }
}
