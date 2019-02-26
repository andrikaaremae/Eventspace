package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/save/{placeId}")
    public Booking save(@PathVariable long placeId, @RequestBody Booking booking) {
        return bookingService.save(placeId, booking);
    }

    @GetMapping("/get/{id}")
    public Optional<Booking> findBookingById(@PathVariable long id) {
        return bookingService.findBookingById(id);
    }

    @GetMapping("/getAll/{id}")
    public List<Booking> findBookingsByPlace(@PathVariable long id) {
        return bookingService.findBookingsByPlace(id);
    }

    @GetMapping("/getAll")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }
}
