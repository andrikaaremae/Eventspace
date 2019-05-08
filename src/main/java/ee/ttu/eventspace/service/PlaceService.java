package ee.ttu.eventspace.service;

import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    public  List<Place> findByOwner(String username) {
        return placeRepository.findByOwner(userRepository.findByUsername(username));
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public List<Place> findByCategory(String category) {
        return placeRepository.findByCategory(category);
    }

    public void deleteById(Long id){placeRepository.deleteById(id);}

    public Place update(Place place) {return placeRepository.save(place);}

    public List<Place> findByCategoryAndCity(String category, String city) {
        return placeRepository.findByCategoryAndAddressCity(category, city);
    }

    public List<String> findDistinctCitiesWithCategory(String category) {
        return placeRepository.findDistinctCitiesWithCategory(category);
    }
}

