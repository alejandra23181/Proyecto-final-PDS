package com.example.movie;

import com.example.movie.entities.Movie;
import com.example.movie.repositories.MovieRepository;
import com.example.movie.services.MovieService;
import com.example.movie.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .id(6l)
                .title("Test")
                .director("Cristian")
                .rating(2)
                .build();
        Mockito.when(movieRepository.findById(6l)).thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie = movieService.findById(6l);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Test");
    }
}
