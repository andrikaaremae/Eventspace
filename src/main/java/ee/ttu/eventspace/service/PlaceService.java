package ee.ttu.eventspace.service;

import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public void deleteById(Long id){placeRepository.deleteById(id);}

}

