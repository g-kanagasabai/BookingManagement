package com.platform.booking.movies.Controller;

import com.platform.booking.movies.model.Movie;
import com.platform.booking.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/onboarding/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title) {
        Optional<Movie> movieOptional = movieService.findMovieByTitle(title);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Optional<Movie> savedMovieOptional = Optional.ofNullable(movieService.saveMovie(movie));

        if (savedMovieOptional.isPresent()) {
            Movie savedMovie = savedMovieOptional.get();
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Other endpoints and methods...


}

