package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ScreeningDto;
import com.example.cinema.controller.dto.SeatDto;
import com.example.cinema.repository.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ScreeningMapper {

    @Autowired
    private SeatMapper seatMapper;

    public Screening dtoToEntity(ScreeningDto screeningDto) {
        if (screeningDto == null) {
            return null;
        }

        Screening screening = new Screening();

        screening.setId(screeningDto.getId());
        screening.setMovieId(screeningDto.getMovieId());
        screening.setStartTime(screeningDto.getStartTime());

        Set<SeatDto> seats = new HashSet<>();
        screening.getSeats().forEach(i -> seats.add(seatMapper.entityToDto(i)));
        screeningDto.setSeats(seats);

        return screening;
    }


    public ScreeningDto entityToDto(Screening screening) {
        if (screening == null) {
            return null;
        }

        ScreeningDto screeningDto = new ScreeningDto();

        screeningDto.setId(screening.getId());
        screeningDto.setMovieId(screening.getMovieId());
        screeningDto.setStartTime(screening.getStartTime());

        Set<SeatDto> seats = new HashSet<>();
        screening.getSeats().forEach(i -> seats.add(seatMapper.entityToDto(i)));
        screeningDto.setSeats(seats);

        return screeningDto;
    }


    public List<ScreeningDto> entitiesToDto(Iterable<Screening> screening) {
        if (screening == null) {
            return null;
        }

        List<ScreeningDto> screeningDtos = new ArrayList<>();

        screening.forEach(i -> screeningDtos.add(entityToDto(i)));

        return screeningDtos;
    }
}
