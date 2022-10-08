package com.example.cinema.service;

import com.example.cinema.controller.dto.ReservationDto;
import com.example.cinema.mapper.ReservationMapper;
import com.example.cinema.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationService {

    @Autowired
    private ReservationMapper movieMappers;
    @Autowired
    private ReservationRepository movieRepository;

    public List<ReservationDto> getAllReservations(){
        return movieMappers.entitiesToDto(movieRepository.findAll());
    }
    public void saveReservation(ReservationDto movieDto){
        movieRepository.save(movieMappers.dtoToEntity(movieDto));
    }

    public ReservationDto getReservation(Long id){
        return movieMappers.entityToDto(movieRepository.findById(id).orElseGet(null));
    }
}
