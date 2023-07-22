package com.platform.booking.theatres.utility;

import com.platform.booking.theatres.data.Showtime;
import com.platform.booking.theatres.model.Seat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SeatUtility {

    @Value("${seats.service.url}")
    private String url;

    public void postSeats(Showtime showtime){
        Optional.ofNullable(showtime)
                .map(st -> this.createSeats(st.getId(), st.getAvailableSeats()))
                .map(this::callSeatService).ifPresent(response -> {
                    if(!"Success".equalsIgnoreCase(response)){
                        throw new RuntimeException("Error creating seats");
                    }
                });
    }

    private String callSeatService(List<Seat> seatList) {
        return WebClient.create().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(seatList))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    private List<Seat> createSeats(long showtimeId, int numberOfSeats){
        return IntStream.rangeClosed(1, numberOfSeats)
                .mapToObj(val -> {
                    Seat seat = new Seat();
                    seat.setSeatNumber(String.valueOf(val));
                    seat.setShowtimeId(showtimeId);
                    seat.setAvailability(true);
                    return seat;
                }).collect(Collectors.toList());
    }
}
