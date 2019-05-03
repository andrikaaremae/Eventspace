package ee.ttu.eventspace.service;

import ee.ttu.eventspace.model.Rating;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public Rating save(Long placeId, Rating rating) {
        rating.setPlace(placeRepository.findById(placeId).orElseThrow(IllegalArgumentException::new));
        return ratingRepository.save(rating);
    }

    public Optional<Rating> findById(Long id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findByCustomer(String username) { return ratingRepository.findByCustomer(username); }

    public void deleteById(Long id){ratingRepository.deleteById(id);}
}