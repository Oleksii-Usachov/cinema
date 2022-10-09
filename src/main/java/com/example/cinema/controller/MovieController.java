package com.example.cinema.controller;

import com.example.cinema.controller.dto.MovieDto;
import com.example.cinema.mapper.MovieMappers;
import com.example.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMappers movieMappers;

    @GetMapping(value = "/all")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping
    public MovieDto getMovie(@RequestParam("movieId") Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/director")
    public List<MovieDto> getMovieByDirector(@RequestParam("director") String director) {
        return movieService.getMovieByDirector(director);
    }
}