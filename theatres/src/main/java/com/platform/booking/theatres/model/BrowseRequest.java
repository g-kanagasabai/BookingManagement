package com.platform.booking.theatres.model;

import java.time.LocalDate;

public class BrowseRequest {

    private Long movieId;
    private String location;
    private LocalDate day;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
