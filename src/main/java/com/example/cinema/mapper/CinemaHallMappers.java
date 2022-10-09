package com.example.cinema.mapper;

import com.example.cinema.controller.dto.CinemaHallDto;
import com.example.cinema.repository.entity.CinemaHall;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaHallMappers {

    public CinemaHall dtoToEntity(CinemaHallDto cinemaHallDto) {
        if (cinemaHallDto == null) {
            return null;
        }

        CinemaHall cinemaHall = new CinemaHall();

        cinemaHall.setId(cinemaHallDto.getId());
        cinemaHall.setName(cinemaHallDto.getName());
        cinemaHall.setSeatsNumber(cinemaHallDto.getSeatsNumber());

        return cinemaHall;
    }


    public CinemaHallDto entityToDto(CinemaHall cinemaHall) {
        if (cinemaHall == null) {
            return null;
        }

        CinemaHallDto cinemaHallDto = new CinemaHallDto();

        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setName(cinemaHall.getName());
        cinemaHallDto.setSeatsNumber(cinemaHall.getSeatsNumber());


        return cinemaHallDto;
    }


    public List<CinemaHallDto> entitiesToDto(Iterable<CinemaHall> cinemaHall) {
        if (cinemaHall == null) {
            return null;
        }

        List<CinemaHallDto> cinemaHallDtos = new ArrayList<>();

        cinemaHall.forEach(i -> cinemaHallDtos.add(entityToDto(i)));

        return cinemaHallDtos;
    }
}
