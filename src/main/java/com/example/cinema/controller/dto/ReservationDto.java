package com.example.cinema.controller.dto;

import lombok.Data;

@Data
public class ReservationDto {

    private Long id;
    private Long screeningId;
    private Boolean isReserved;
    private Long viewerId;
}
