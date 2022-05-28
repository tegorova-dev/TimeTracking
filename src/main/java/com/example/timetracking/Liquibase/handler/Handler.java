package com.example.timetracking.Liquibase.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class Handler {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorInfoDto> handleException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfoDto("malformed_json_request", e.getLocalizedMessage() + HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<ErrorInfoDto> handleException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorInfoDto("UNSUPPORTED_MEDIA_TYPE", e.getLocalizedMessage()));
    }

//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//    public ResponseEntity<ErrorInfoDto> handleException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
//        log.error(e.getMessage());
//        return ResponseEntity
//                .status(ErrorDescription.UNKNOWN_ERROR.getStatus())
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(new ErrorInfoDto(ErrorDescription.UNKNOWN_ERROR.getCode(), ErrorDescription.UNKNOWN_ERROR.getText()));
//    }
}
