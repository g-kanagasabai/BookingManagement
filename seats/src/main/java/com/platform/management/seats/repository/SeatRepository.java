package com.platform.management.seats.repository;
import com.platform.management.seats.data.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.bookingId = :bookingId, s.availability = false " +
            "WHERE s.seatNumber IN :seatNames AND s.showtimeId = :showtimeId AND s.availability = true")
    void updateSeatsBookingIdAndAvailability(@Param("bookingId") Long bookingId,
                                             @Param("seatNames") List<String> seatNames,
                                             @Param("showtimeId") Long showtimeId);


}
