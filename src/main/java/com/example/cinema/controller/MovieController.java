package com.example.cinema.controller;

import com.example.cinema.controller.dto.MovieDto;
import com.example.cinema.mapper.MovieMapper;
import com.example.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping
    public ResponseEntity<MovieDto> getMovie(@RequestParam("movieId") Long id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @GetMapping("/director")
    public ResponseEntity<List<MovieDto>> getMovieByDirector(@RequestParam("director") String director) {
        return ResponseEntity.ok(movieService.getMovieByDirector(director));
    }
}