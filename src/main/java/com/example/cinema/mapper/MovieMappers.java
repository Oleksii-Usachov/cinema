package com.example.cinema.mapper;

import com.example.cinema.controller.dto.MovieDto;
import com.example.cinema.repository.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMappers {

    public Movie dtoToEntity(MovieDto movieDto) {
        if (movieDto == null) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId(movieDto.getId());
        movie.setDirector(movieDto.getDirector());
        movie.setTitle(movieDto.getTitle());

        return movie;
    }


    public MovieDto entityToDto(Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setDirector(movie.getDirector());
        movieDto.setTitle(movie.getTitle());


        return movieDto;
    }


    public List<MovieDto> entitiesToDto(Iterable<Movie> movie) {
        if (movie == null) {
            return null;
        }

        List<MovieDto> movieDtos = new ArrayList<>();

        movie.forEach(i -> movieDtos.add(entityToDto(i)));

        return movieDtos;
    }
}
