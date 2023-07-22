package com.platform.booking.theatres.repository;

import com.platform.booking.theatres.data.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.*;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {

    Optional<List<Theatre>> findTheatreByName(String name);
    Optional<List<Theatre>> findTheatreByLocation(String location);
    //@Query("SELECT t FROM Theatre t WHERE t.name = ?1 AND t.location = ?2")
    Optional<List<Theatre>> findByNameAndLocation(String name, String location );

}
