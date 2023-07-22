package com.platform.booking.movies.service;

import com.platform.booking.movies.model.Movie;
//import com.platform.booking.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //private final MovieRepository movieRepository;

    @Value("${film.service.url}")
    private String url;

    @Value("${film.service.save.url}")
    private String saveUrl;

    @Autowired
    WebClient webClient;

    /*@Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }*/

    public Optional<Movie> findMovieByTitle(String movieTitle) {


        String requestUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("movieTitle", movieTitle)
                .build()
                .toString();

        Mono<Movie> responseMono = webClient.get()
                .uri(requestUrl)
                .retrieve()
                .bodyToMono(Movie.class);

        return Optional.ofNullable(responseMono.block());
        /*return Optional.ofNullable(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("movieTitle", movieTitle)
                        .build())
                .retrieve()
                .bodyToMono(Movie.class).block());*/

        //return movieRepository.findByMovieTitle(movieTitle);
    }

    public Movie saveMovie(Movie movie){
       return webClient.post()
                .uri(saveUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(movie))
                .retrieve()
                .bodyToMono(Movie.class).block();
        //return movieRepository.save(movie);
    }

    // Other methods in the service...
}