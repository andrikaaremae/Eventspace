package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Rating;
import ee.ttu.eventspace.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/get/{id}")
    public Optional<Rating> findById(@PathVariable Long id) { return ratingService.findById(id); }

    @GetMapping("/getCustomer/{username}")
    public Optional<Rating> findByCustomer(@PathVariable String username) { return ratingService.findByCustomer(username); }

    @GetMapping("/getAll")
    public List<Rating> findAll() {
        return ratingService.findAll();
    }

    @PostMapping("/save/{placeId}")
    public Rating save(@PathVariable Long placeId, @RequestBody Rating rating) {
        return ratingService.save(placeId, rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRating (@PathVariable ("id") Long id){ratingService.deleteById(id);
    }
}