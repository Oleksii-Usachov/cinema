package com.example.cinema.mapper;

import com.example.cinema.controller.dto.SeatDto;
import com.example.cinema.repository.entity.Seat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    Seat dtoToEntity(SeatDto seatDto);

    SeatDto entityToDto(Seat seat);

    List<SeatDto> entitiesToDto(Iterable<Seat> seat);
}
