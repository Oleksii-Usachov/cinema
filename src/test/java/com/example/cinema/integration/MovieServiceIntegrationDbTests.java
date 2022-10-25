package com.example.cinema.integration;

import com.example.cinema.core.AbstractDbTest;
import com.example.cinema.dto.MovieDto;
import com.example.cinema.service.MovieService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.MOVIE_DIRECTOR;
import static com.example.cinema.constants.UnitTestingConstants.MOVIE_TITLE;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_ID;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_MOVIE_DIRECTOR;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_MOVIE_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieServiceIntegrationDbTests extends AbstractDbTest {

    @Autowired
    MovieService movieService;

    private MovieDto movieDto;

    @BeforeEach
    void setUp() {
        movieDto = new MovieDto();
        movieDto.setId(ID);
        movieDto.setTitle(MOVIE_TITLE);
        movieDto.setDirector(MOVIE_DIRECTOR);
    }

    @Test
    void givenValidDataIsProvided_thenAllMoviesAreReturned() {
        List<MovieDto> movieList = new ArrayList<>();
        movieList.add(new MovieDto(ID, MOVIE_TITLE, MOVIE_DIRECTOR));
        movieList.add(new MovieDto(SECOND_ID, SECOND_MOVIE_TITLE, SECOND_MOVIE_DIRECTOR));

        List<MovieDto> allMoviesList = movieService.getAllMovies();

        assertEquals(movieList, allMoviesList);
    }

    @Test
    void givenValidDataIsProvided_thenMovieByIdIsReturned() {
        MovieDto movie = movieService.getMovie(movieDto.getId());

        assertEquals(movieDto, movie);
    }

    @Test
    void givenValidDataIsProvided_thenMovieByDirectorIsReturned() {
        List<MovieDto> movieList = movieService.getMovieByDirector(movieDto.getDirector());

        SoftAssertions assertions = new SoftAssertions();
        movieList.forEach(it -> assertions.assertThat(it.getDirector()).as("Movie not found")
                .isEqualTo(movieDto.getDirector()));
        assertions.assertAll();
    }
}
