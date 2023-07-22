package com.platform.booking.tickets.service;

import com.github.dozermapper.core.Mapper;
import com.platform.booking.tickets.data.Booking;
import com.platform.booking.tickets.model.BookingRequest;
import com.platform.booking.tickets.repository.BookingRepository;
import com.platform.booking.tickets.utility.SeatUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final SeatUtility seatUtility;

    private final Mapper mapper;

    public BookingService(BookingRepository bookingRepository, SeatUtility seatUtility,Mapper mapper){
        this.bookingRepository= bookingRepository;
        this.seatUtility = seatUtility;
        this.mapper = mapper;
    }

    public void makeBooking(BookingRequest bookingRequest){

        Booking booking = mapper.map(bookingRequest, Booking.class);
        booking.setBookingDate(LocalDateTime.now());
        ResponseEntity<String> paymentResponseEntity = makePayment(booking.getTotalAmount());
        if(Objects.nonNull(paymentResponseEntity) && !paymentResponseEntity.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("Payment failed");
        }

        Booking bookingWithId = bookingRepository.save(booking);
        String response = null;
        try{
            response = seatUtility.updateSeats(bookingRequest.getSeatNames(), bookingWithId);

        }catch(Exception ex){
            compensateActions(bookingWithId);
            throw new RuntimeException("Please try again");
        }

        if(Objects.isNull(response) || !"Success".equalsIgnoreCase(response)){
            compensateActions(bookingWithId);
            throw new RuntimeException("Seat Unavailable. Please try with other seats");
        }

    }

    private ResponseEntity<String> makePayment(BigDecimal amount){
        return ResponseEntity.ok().body("SUCCESS");
    }

    private ResponseEntity<String> reversePayments(BigDecimal amount){
        return ResponseEntity.ok().body("SUCCESS");
    }

    private void compensateActions(Booking booking){
        reversePayments(booking.getTotalAmount());
        bookingRepository.delete(booking);
    }
}
