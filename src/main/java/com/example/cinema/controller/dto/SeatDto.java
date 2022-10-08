package com.example.cinema.controller.dto;

import lombok.Data;

@Data
public class SeatDto {

    private Long id;
    private String row;
    private String number;
    private String cinemaHallId;
}
