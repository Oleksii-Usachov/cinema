package com.example.cinema.controller.dto;

import lombok.Data;

@Data
public class SeatDto {

    private Long id;
    private Integer row;
    private Integer number;
    private Integer cinemaHallId;
    private Boolean isAvailable;
}
