package com.platform.booking.theatres.service;

import com.platform.booking.theatres.data.Theatre;
import com.platform.booking.theatres.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository){
        this.theatreRepository=theatreRepository;
    }

    public Optional<List<Theatre>> findByLocation(String location){
        return theatreRepository.findTheatreByLocation(location);
    }

    public Optional<List<Theatre>>  findByName(String name){
        return theatreRepository.findTheatreByLocation(name);
    }

    public Optional<List<Theatre>>  findByNameAndLocation(String name, String location){
        if(Objects.nonNull(name) && Objects.nonNull(location)){
            return theatreRepository.findByNameAndLocation(name, location);
        }else if(Objects.nonNull(name)){
            return theatreRepository.findTheatreByName(name);
        }else if(Objects.nonNull(location)){
            return theatreRepository.findTheatreByLocation(location);
        }
        return null;

    }

    public Optional<Theatre> saveTheatre(Theatre theatre){
        return Optional.of(theatreRepository.save(theatre));
    }
}
