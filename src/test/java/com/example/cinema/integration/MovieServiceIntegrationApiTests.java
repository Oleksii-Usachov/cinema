package com.example.cinema.integration;

import com.example.cinema.core.AbstractApiTest;
import com.example.cinema.dto.MovieDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.MOVIE_DIRECTOR;
import static com.example.cinema.constants.UnitTestingConstants.MOVIE_TITLE;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_ID;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_MOVIE_DIRECTOR;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_MOVIE_TITLE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MovieServiceIntegrationApiTests extends AbstractApiTest {

    private MovieDto mockMovie;

    @BeforeEach
    public void setUp() {
        mockMovie = new MovieDto();
        mockMovie.setId(ID);
        mockMovie.setTitle(MOVIE_TITLE);
        mockMovie.setDirector(MOVIE_DIRECTOR);
    }

    @Test
    void allMoviesAreReturned() throws Exception {
        MovieDto secondMockMovie = new MovieDto();
        secondMockMovie.setId(SECOND_ID);
        secondMockMovie.setTitle(SECOND_MOVIE_TITLE);
        secondMockMovie.setDirector(SECOND_MOVIE_DIRECTOR);

        List<MovieDto> movieList = new ArrayList<>();
        movieList.add(mockMovie);
        movieList.add(secondMockMovie);
        String expectedListOfMovies = OBJECT_MAPPER.writeValueAsString(movieList);

        mockMvc.perform(MockMvcRequestBuilders.get("/movie/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedListOfMovies));
    }

    @Test
    void whenValidIdIsProvided_thenMovieReturned() throws Exception {
        String expectedValue = OBJECT_MAPPER.writeValueAsString(mockMovie);

        mockMvc.perform(MockMvcRequestBuilders.get("/movie")
                .param("movieId", mockMovie.getId().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedValue));
    }

    @Test
    void whenValidDirectorIsProvided_thenMovieIsReturned() throws Exception {
        List<MovieDto> movieList = new ArrayList<>();
        movieList.add(mockMovie);
        String expectedValue = OBJECT_MAPPER.writeValueAsString(movieList);

        mockMvc.perform(MockMvcRequestBuilders.get("/movie/director")
                .param("director", mockMovie.getDirector())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedValue));
    }
}
