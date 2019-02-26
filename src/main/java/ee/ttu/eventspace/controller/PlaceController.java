package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.service.BookingService;
import ee.ttu.eventspace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/get/{id}")
    public Optional<Place> findById(@PathVariable Long id) {
        return placeService.findById(id);
    };

    @GetMapping("/getAll")
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @PostMapping("/add")
    public Place add(@RequestBody Place place) {
        return placeService.save(place);
    };
}