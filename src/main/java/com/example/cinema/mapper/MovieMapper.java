package com.example.cinema.mapper;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.repository.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie dtoToEntity(MovieDto movieDto);

    MovieDto entityToDto(Movie movie);

    List<MovieDto> entitiesToDto(Iterable<Movie> movie);
}
