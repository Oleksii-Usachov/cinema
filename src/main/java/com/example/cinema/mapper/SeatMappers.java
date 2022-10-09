package com.example.cinema.mapper;

import com.example.cinema.controller.dto.SeatDto;
import com.example.cinema.repository.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatMappers {

    public Seat dtoToEntity(SeatDto seatDto) {
        if (seatDto == null) {
            return null;
        }

        Seat seat = new Seat();

        seat.setId(seatDto.getId());
        seat.setRow(seatDto.getRow());
        seat.setNumber(seatDto.getNumber());
        seat.setCinemaHallId(seatDto.getCinemaHallId());
        seat.setIsAvailable(seatDto.getIsAvailable());

        return seat;
    }


    public SeatDto entityToDto(Seat seat) {
        if (seat == null) {
            return null;
        }

        SeatDto seatDto = new SeatDto();

        seatDto.setId(seat.getId());
        seatDto.setRow(seat.getRow());
        seatDto.setNumber(seat.getNumber());
        seatDto.setCinemaHallId(seat.getCinemaHallId());
        seatDto.setIsAvailable(seat.getIsAvailable());


        return seatDto;
    }


    public List<SeatDto> entitiesToDto(Iterable <Seat> seat) {
        if (seat == null) {
            return null;
        }

        List<SeatDto> seatDtos = new ArrayList<>();

        seat.forEach(i -> seatDtos.add(entityToDto(i)));

        return seatDtos;
    }
}
