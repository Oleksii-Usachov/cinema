package com.example.cinema.unit;

import com.example.cinema.core.AbstractUnitTest;
import com.example.cinema.dto.MovieDto;
import com.example.cinema.mapper.MovieMapper;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.entity.Movie;
import com.example.cinema.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.TEST;
import static java.util.Optional.of;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MovieUnitTests extends AbstractUnitTest {

    @Autowired
    MovieService movieService;
    @MockBean
    MovieMapper movieMapper;
    @MockBean
    MovieRepository movieRepository;

    Movie mockMovie;
    MovieDto mockMovieDto;

    @BeforeEach
    void setup() {
        reset(movieRepository);

        mockMovie = new Movie();
        mockMovie.setTitle(TEST);
        mockMovie.setDirector(TEST);
        mockMovie.setId(ID);

        mockMovieDto = new MovieDto();
        mockMovieDto.setTitle(TEST);
        mockMovieDto.setDirector(TEST);
        mockMovieDto.setId(ID);
    }

    @Test
    void whenMoviesAreFound_thenAllMoviesAreReturned() {
        List<Movie> movies = Collections.singletonList(mockMovie);
        List<MovieDto> movieDtos = new ArrayList<>();
        movieDtos.add(mockMovieDto);

        when(movieRepository.findAll()).thenReturn(movies);
        when(movieMapper.entitiesToDto(movies)).thenReturn(movieDtos);

        movieService.getAllMovies();

        verify(movieMapper).entitiesToDto(movies);
    }

    @Test
    void whenMovieIsFoundById_thenMovieReturned() {
        when(movieRepository.findById(mockMovie.getId())).thenReturn(of(mockMovie));
        when(movieMapper.entityToDto(mockMovie)).thenReturn(mockMovieDto);

        movieService.getMovie(mockMovie.getId());

        verify(movieMapper).entityToDto(mockMovie);
    }

    @Test
    void whenMovieIsFoundByDirector_thenMovieIsReturned() {
        List<Movie> movies = Collections.singletonList(mockMovie);
        List<MovieDto> movieDtos = new ArrayList<>();
        movieDtos.add(mockMovieDto);

        when(movieRepository.findMovieByDirector(mockMovie.getDirector())).thenReturn(movies);
        when(movieMapper.entitiesToDto(movies)).thenReturn(movieDtos);

        movieService.getMovieByDirector(mockMovie.getDirector());

        verify(movieMapper).entitiesToDto(movies);
    }
}
