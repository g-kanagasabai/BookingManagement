package com.platform.management.seats.controller;

import com.platform.management.seats.data.Seat;
import com.platform.management.seats.model.UpdateSeatRequest;
import com.platform.management.seats.service.SeatManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatManagementController {

    private final SeatManagementService seatManagementService;

    public SeatManagementController(SeatManagementService seatManagementService){
        this.seatManagementService = seatManagementService;
    }

    @PostMapping("/list")
    public ResponseEntity<String> saveSeats(@RequestBody List<Seat> seatList){
        seatManagementService.saveSeats(seatList);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSeats(@RequestBody UpdateSeatRequest updateSeatRequest){
        seatManagementService.updateSeats(updateSeatRequest);
        return ResponseEntity.ok("Success");
    }
}
