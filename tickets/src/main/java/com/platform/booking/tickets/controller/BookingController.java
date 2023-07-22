package com.platform.booking.tickets.controller;

import com.platform.booking.tickets.model.BookingRequest;
import com.platform.booking.tickets.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    @PostMapping
    public ResponseEntity<String> makeBooking(@RequestBody BookingRequest bookingRequest){
        bookingService.makeBooking(bookingRequest);
        return ResponseEntity.ok().body("Success");
    }
}
