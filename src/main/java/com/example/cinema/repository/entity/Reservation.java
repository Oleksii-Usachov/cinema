package com.example.cinema.repository.entity;

import com.example.cinema.constants.ReservationStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long screeningId;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
    private Long viewerId;
    private Long seatId;
}
