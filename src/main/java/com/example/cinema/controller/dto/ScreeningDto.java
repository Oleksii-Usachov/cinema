package com.example.cinema.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScreeningDto {

    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime startTime;
}
