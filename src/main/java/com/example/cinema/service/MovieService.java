package com.example.cinema.service;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.mapper.MovieMapper;
import com.example.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDto> getAllMovies() {
        return movieMapper.entitiesToDto(movieRepository.findAll());
    }

    public MovieDto getMovie(Long id) {
        return movieMapper.entityToDto(movieRepository.findById(id).orElseGet(null));
    }

    public List<MovieDto> getMovieByDirector(String director) {
        return movieMapper.entitiesToDto(movieRepository.findMovieByDirector(director));
    }
}
