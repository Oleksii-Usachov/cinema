package com.example.cinema.controller;

import com.example.cinema.dto.CommonErrorResponse;
import com.example.cinema.exception.BadRequestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public CommonErrorResponse handleBadRequestException(BadRequestException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
    }
}
