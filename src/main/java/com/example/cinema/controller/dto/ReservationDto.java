package com.example.cinema.controller.dto;

import com.example.cinema.constants.ReservationStatus;
import lombok.Data;

@Data
public class ReservationDto {

    private Long id;
    private Long screeningId;
    private ReservationStatus reservationStatus;
    private Long viewerId;
    private Long seatId;
}
