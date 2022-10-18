package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ReservationDto;
import com.example.cinema.repository.entity.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper {


    public Reservation dtoToEntity(ReservationDto reservationDto) {
        if (reservationDto == null) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId(reservationDto.getId());
        reservation.setScreeningId(reservationDto.getScreeningId());
        reservation.setReservationStatus(reservationDto.getReservationStatus());
        reservation.setViewerId(reservationDto.getViewerId());
        reservation.setSeatId(reservationDto.getSeatId());

        return reservation;
    }


    public ReservationDto entityToDto(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId(reservation.getId());
        reservationDto.setScreeningId(reservation.getScreeningId());
        reservationDto.setReservationStatus(reservation.getReservationStatus());
        reservationDto.setViewerId(reservation.getViewerId());
        reservationDto.setSeatId(reservation.getSeatId());

        return reservationDto;
    }


    public List<ReservationDto> entitiesToDto(Iterable<Reservation> reservation) {
        if (reservation == null) {
            return null;
        }

        List<ReservationDto> reservationDtos = new ArrayList<>();

        reservation.forEach(i -> reservationDtos.add(entityToDto(i)));

        return reservationDtos;
    }
}
