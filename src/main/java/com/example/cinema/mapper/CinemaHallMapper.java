package com.example.cinema.mapper;

import com.example.cinema.dto.CinemaHallDto;
import com.example.cinema.repository.entity.CinemaHall;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaHallMapper {

    CinemaHall dtoToEntity(CinemaHallDto cinemaHallDto);

    CinemaHallDto entityToDto(CinemaHall cinemaHall);

    List<CinemaHallDto> entitiesToDto(Iterable<CinemaHall> cinemaHall);
}
