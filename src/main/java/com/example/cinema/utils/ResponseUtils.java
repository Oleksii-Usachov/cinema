package com.example.cinema.utils;

import com.example.cinema.exception.BadRequestException;

public class ResponseUtils {

    private ResponseUtils() {
    }

    public static BadRequestException throwBadRequestException(String message) {
        throw new BadRequestException("400", message);
    }
}
