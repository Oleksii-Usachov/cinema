package com.example.cinema.service;

import com.example.cinema.controller.dto.ScreeningDto;
import com.example.cinema.mapper.ScreeningMapper;
import com.example.cinema.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningMapper screeningMapper;
    @Autowired
    private ScreeningRepository screeningRepository;

    public List<ScreeningDto> getAllScreenings(){
        return screeningMapper.entitiesToDto(screeningRepository.findAll());
    }
    public void saveScreening(ScreeningDto screeningDto){
        screeningRepository.save(screeningMapper.dtoToEntity(screeningDto));
    }

    public ScreeningDto getScreening(Long id){
        return screeningMapper.entityToDto(screeningRepository.findById(id).orElseGet(null));
    }
}
