package com.platform.booking.tickets.utility;

import com.platform.booking.tickets.data.Booking;
import com.platform.booking.tickets.model.UpdateSeatRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Component
public class SeatUtility {

    @Value("${seats.service.url}")
    private String url;

    public String updateSeats(List<String> seatNames, Booking booking){
        return Optional.ofNullable(createUpdateRequest(seatNames,booking))
                .map(this::callSeatService).orElse("Failure");
    }

    private String callSeatService(UpdateSeatRequest updateSeatRequest) {
        return WebClient.create().put()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(updateSeatRequest))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private UpdateSeatRequest createUpdateRequest(List<String> seatNames, Booking booking) {
        UpdateSeatRequest  updateSeatRequest = new UpdateSeatRequest();
        updateSeatRequest.setSeatNames(seatNames);
        updateSeatRequest.setBookingId(booking.getId());
        updateSeatRequest.setShowtimeId(booking.getShowtimeId());
        return updateSeatRequest;
    }
}
