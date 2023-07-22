package com.platform.booking.theatres.service;

import com.github.dozermapper.core.Mapper;
import com.platform.booking.theatres.data.Showtime;
import com.platform.booking.theatres.data.Theatre;
import com.platform.booking.theatres.model.BrowseRequest;
import com.platform.booking.theatres.model.ShowTiming;
import com.platform.booking.theatres.repository.ShowtimeRepository;
import com.platform.booking.theatres.repository.TheatreRepository;
import com.platform.booking.theatres.utility.SeatUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    private final TheatreRepository theatreRepository;
    private final Mapper dozerBeanMapper;

    private final SeatUtility seatUtility;

    public ShowtimeService(ShowtimeRepository showtimeRepository,TheatreRepository theatreRepository, Mapper dozerBeanMapper, SeatUtility seatUtility){
        this.showtimeRepository = showtimeRepository;
        this.theatreRepository = theatreRepository;
        this.dozerBeanMapper = dozerBeanMapper;
        this.seatUtility = seatUtility;
    }

    public List<ShowTiming> findShows(BrowseRequest browseRequest){
        Optional<List<Showtime>> showTimesOptional = showtimeRepository.findByMovieIDAndDayAndTheatreLocation(browseRequest.getMovieId(),
                browseRequest.getDay(),browseRequest.getLocation());

        return showTimesOptional.stream().flatMap(List::stream).map(st -> {
            ShowTiming showT = dozerBeanMapper.map(st, ShowTiming.class);
            showT.setTheatre_id(st.getTheatre().getId());
            return showT;
        }).collect(Collectors.toList());
    }

    public Optional<ShowTiming> saveShowtime(ShowTiming showTiming) {
        Showtime showtime = dozerBeanMapper.map(showTiming, Showtime.class);
        Theatre theatre = theatreRepository.getReferenceById(showTiming.getTheatre_id());
        showtime.setTheatre(theatre);

        Optional<Showtime> showOptional = Optional.of(showtimeRepository.save(showtime));

        showOptional.ifPresent(seatUtility::postSeats);

        return showOptional.map(st -> {
                    ShowTiming showT = dozerBeanMapper.map(st, ShowTiming.class);
                    showT.setTheatre_id(st.getTheatre().getId());
                    return showT;
                });
    }

    public void deleteShowtime(Long id) {
        Showtime showtime = showtimeRepository.getReferenceById(id);
        showtimeRepository.delete(showtime);
    }


}
