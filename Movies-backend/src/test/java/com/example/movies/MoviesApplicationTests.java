package com.example.movies;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MoviesApplicationTests {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Test
    public void testGetAllMovies() {
        // Mock data
        Movie movie1 = new Movie(new ObjectId("65bbd864665ad5da290b35a2"), "Avatar: The Way of Water", "tt1630029");
        Movie movie2 = new Movie(new ObjectId("65bbd864665ad5da290b35a5"), "Black Adam", "tt6443346");
        List<Movie> movies = Arrays.asList(movie1, movie2);

        // Mocking the behavior of the movieService
        when(movieService.allMovies()).thenReturn(movies);

        // Calling the controller method
        ResponseEntity<List<Movie>> response = movieController.getAllMovies();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    public void testGetSingleMovie() {
        // Mock data
        Movie movie = new Movie(new ObjectId("65bbd864665ad5da290b35a5"), "Black Adam", "tt6443346");

        // Mocking the behavior of the movieService
        when(movieService.singleMovie("tt6443346")).thenReturn(Optional.of(movie));

        // Calling the controller method
        ResponseEntity<Optional<Movie>> response = movieController.getSingleMovie("tt6443346");

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.of(movie), response.getBody());
    }

}
