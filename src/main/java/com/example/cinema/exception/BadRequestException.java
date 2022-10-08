package com.example.cinema.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public BadRequestException(String errorCode, String errorMessage) {
        super(errorMessage, null, false, false);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
