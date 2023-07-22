package com.platform.management.seats.service;

import com.platform.management.seats.data.Seat;
import com.platform.management.seats.repository.SeatRepository;
import org.springframework.stereotype.Service;
import com.platform.management.seats.model.UpdateSeatRequest;

import java.util.List;
@Service
public class SeatManagementService {

    private final SeatRepository seatRepository;

    public SeatManagementService(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    public void saveSeats(List<Seat> seatList){
        seatRepository.saveAll(seatList);
    }

    public void updateSeats(UpdateSeatRequest updateSeatRequest){
        seatRepository.updateSeatsBookingIdAndAvailability(updateSeatRequest.getBookingId(),
                updateSeatRequest.getSeatNames(),
                updateSeatRequest.getShowtimeId());
    }
}
