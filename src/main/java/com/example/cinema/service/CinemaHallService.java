package com.example.cinema.service;

import com.example.cinema.controller.dto.CinemaHallDto;
import com.example.cinema.controller.dto.ScreeningDto;
import com.example.cinema.mapper.CinemaHallMapper;
import com.example.cinema.mapper.ScreeningMapper;
import com.example.cinema.repository.CinemaHallRepository;
import com.example.cinema.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {

    @Autowired
    private CinemaHallMapper cinemaHallMappers;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningMapper screeningMappers;

    public List<CinemaHallDto> getAllCinemaHalls() {
        return cinemaHallMappers.entitiesToDto(cinemaHallRepository.findAll());
    }

    public void saveCinemaHall(CinemaHallDto cinemaHallDto) {
        cinemaHallRepository.save(cinemaHallMappers.dtoToEntity(cinemaHallDto));
    }

    public CinemaHallDto getCinemaHall(Long id) {
        return cinemaHallMappers.entityToDto(cinemaHallRepository.findById(id).orElseGet(null));
    }

    public void createScreen(ScreeningDto screeningDto) {
        screeningRepository.save(screeningMappers.dtoToEntity(screeningDto));
    }
}
