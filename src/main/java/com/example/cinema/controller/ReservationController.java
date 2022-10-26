package com.example.cinema.controller;

import com.example.cinema.dto.ReservationDto;
import com.example.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/reserve-seat")
    public ResponseEntity<ReservationDto> reserveSeat(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.reserveSeat(reservationDto));
    }
}
