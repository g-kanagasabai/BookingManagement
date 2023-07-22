package com.platform.management.seats.model;

import com.platform.management.seats.data.Seat;

import java.util.List;

public class SeatRequest {

    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
