package ee.ttu.eventspace.service;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public Booking save(Long placeId, Booking booking) {
        booking.setPlace(placeRepository.findById(placeId).get());
        return bookingRepository.save(booking);
    }

    public Booking saveTest(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findBookingsByPlace(Long id) {
        return placeRepository.findById(id).get().getBookings();
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
