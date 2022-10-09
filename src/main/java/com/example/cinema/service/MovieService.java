package com.example.cinema.service;

import com.example.cinema.controller.dto.MovieDto;
import com.example.cinema.mapper.MovieMappers;
import com.example.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieMappers movieMappers;
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDto> getAllMovies() {
        return movieMappers.entitiesToDto(movieRepository.findAll());
    }

    public MovieDto getMovie(Long id) {
        return movieMappers.entityToDto(movieRepository.findById(id).orElseGet(null));
    }

    public List<MovieDto> getMovieByDirector(String director) {
        return movieMappers.entitiesToDto(movieRepository.findMovieByDirector(director));
    }
}
