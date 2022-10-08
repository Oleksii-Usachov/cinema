package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ReservationDto;
import com.example.cinema.repository.entity.Reservation;

import java.util.List;

public interface ReservationMapper {

    Reservation dtoToEntity(ReservationDto reservationDto);

    ReservationDto entityToDto(Reservation reservation);

    List<ReservationDto> entitiesToDto(Iterable<Reservation> reservation);
}
