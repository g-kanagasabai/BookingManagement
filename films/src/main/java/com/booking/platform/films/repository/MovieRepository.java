package com.booking.platform.films.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.booking.platform.films.data.Movie;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "movies")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Additional custom query methods can be defined here if needed

    Optional<Movie> findByMovieTitle(String movieTitle);



}
