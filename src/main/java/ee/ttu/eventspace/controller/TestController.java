package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/hello")
    public String getHello() {
        return "Find your perfect event space";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "This controller is " + this + ", first place in repository: " + placeRepository.findById(1L) + ", first" +
                " user: " + userRepository.findById(1L) + ", first booking: " + bookingRepository.findById(1L);
    }
}
