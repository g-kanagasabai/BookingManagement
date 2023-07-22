package com.platform.booking.theatres.controller;

import com.platform.booking.theatres.data.Theatre;
import com.platform.booking.theatres.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final  TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> getTheatre(@RequestParam String location, @RequestParam(required = false) String name) {
        Optional<List<Theatre>> theatreOptional = theatreService.findByNameAndLocation(name,location);
        if (theatreOptional.isPresent()) {
            List<Theatre> theatreList = theatreOptional.get();
            return ResponseEntity.ok(theatreList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre){
        Optional<Theatre> theatreOptional = theatreService.saveTheatre(theatre);
        if (theatreOptional.isPresent()) {
            Theatre movie = theatreOptional.get();
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}