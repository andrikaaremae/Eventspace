package ee.ttu.eventspace.service;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public Booking findById(Long id) {
        return bookingRepository.findById(id).get();
    }

    public Booking save(Long placeId, Booking booking) {
        booking.setPlace(placeRepository.findById(placeId).orElseThrow(IllegalArgumentException::new));
        return bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findBookingsByPlace(Long id) {
        return placeRepository.findById(id).orElseThrow(IllegalArgumentException::new).getBookings();
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void book(Long bookingId, User customer) {
        userRepository.save(customer);
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(IllegalArgumentException::new);
        booking.setCustomer(customer);
        bookingRepository.save(booking);
    }
}
