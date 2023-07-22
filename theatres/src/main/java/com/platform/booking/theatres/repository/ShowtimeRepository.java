package com.platform.booking.theatres.repository;

import com.platform.booking.theatres.data.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {


    Optional<List<Showtime>> findByDayGreaterThanEqual(LocalDate day);

    Optional<List<Showtime>> findByMovieIDAndDayAndTheatreLocation(Long movieId, LocalDate day, String theatreLocation);

    Optional<List<Showtime>> findByDayAndMovieIDAndStartTimeGreaterThanEqual(LocalDate day, Long movieId, LocalDateTime startTime);

}
