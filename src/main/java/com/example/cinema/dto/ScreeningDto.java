package com.example.cinema.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ScreeningDto {

    private Long id;
    private Long movieId;
    private LocalDateTime startTime;
    private Set<SeatDto> seats;
}
