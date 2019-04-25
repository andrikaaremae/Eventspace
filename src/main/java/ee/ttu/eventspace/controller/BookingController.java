package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/save/{placeId}")
    public Booking save(@PathVariable Long placeId, @RequestBody Booking booking) {
        return bookingService.save(placeId, booking);
    }

    @GetMapping("/get/{id}")
    public Optional<Booking> findBookingById(@PathVariable Long id) {
        return bookingService.findBookingById(id);
    }

    @GetMapping("/getAll/{id}")
    public List<Booking> findBookingsByPlace(@PathVariable Long id) {
        return bookingService.findBookingsByPlace(id);
    }

    @GetMapping("/getAll")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @PatchMapping("/setCustomer/{id}")
    public void setCustomer(@PathVariable Long id, @RequestBody User customer) {
        bookingService.book(id, customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooking (@PathVariable ("id") Long id){bookingService.deleteById(id);
    }
}
