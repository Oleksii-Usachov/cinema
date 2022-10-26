package com.example.cinema.mapper;

import com.example.cinema.dto.ReservationDto;
import com.example.cinema.repository.entity.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    Reservation dtoToEntity(ReservationDto reservationDto);

    ReservationDto entityToDto(Reservation reservation);

    List<ReservationDto> entitiesToDto(Iterable<Reservation> reservation);
}
