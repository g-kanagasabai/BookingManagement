package com.platform.booking.theatres.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowTiming {
    private Long id;
    private Long movieID;
    private Long theatre_id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int availableSeats;
    private LocalDate day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public Long getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(Long theatre_id) {
        this.theatre_id = theatre_id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
