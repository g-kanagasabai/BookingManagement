package com.platform.booking.tickets.model;

public class Seat {


    private Long id;


    private Long showtimeId;


    private String seatNumber;


    private Long bookingId;


    private Boolean availability;


    public Seat() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}