package com.platform.booking.theatres.controller;

import com.platform.booking.theatres.data.Showtime;
import com.platform.booking.theatres.model.BrowseRequest;
import com.platform.booking.theatres.model.ShowTiming;
import com.platform.booking.theatres.service.ShowtimeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService){
        this.showtimeService = showtimeService;
    }

    @PostMapping
    public ResponseEntity<ShowTiming> createShowtime(@RequestBody ShowTiming showTimingRequest){
        Optional<ShowTiming> showtimeOptional = showtimeService.saveShowtime(showTimingRequest);
        if (showtimeOptional.isPresent()) {
            ShowTiming showTimingResponse = showtimeOptional.get();
            return ResponseEntity.ok(showTimingResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    public ResponseEntity<ShowTiming> updateShowtime(@RequestBody ShowTiming showTimingRequest){
        Optional<ShowTiming> showtimeOptional = showtimeService.saveShowtime(showTimingRequest);
        if (showtimeOptional.isPresent()) {
            ShowTiming showTimingResponse = showtimeOptional.get();
            return ResponseEntity.ok(showTimingResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShowtime(@PathVariable Long id){
        showtimeService.deleteShowtime(id);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/browse")
    public ResponseEntity<List<ShowTiming>> findShows(@RequestBody BrowseRequest browseRequest){
        List<ShowTiming> showtimeList = showtimeService.findShows(browseRequest);

        if(CollectionUtils.isNotEmpty(showtimeList)){
            return ResponseEntity.ok(showtimeList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
