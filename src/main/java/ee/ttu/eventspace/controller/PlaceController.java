package ee.ttu.eventspace.controller;

import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.service.BookingService;
import ee.ttu.eventspace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    }

    @GetMapping("/getAll")
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @GetMapping("/getCategory/{category}")
    public List<Place> findByCategory(@PathVariable String category) {
        return placeService.findByCategory(category);
    }

    @GetMapping("getAll/category={category}&city={city}")
    public List<Place> findByCategoryAndCity(@PathVariable("category") String category, @PathVariable("city") String city) {
        return placeService.findByCategoryAndCity(category, city);
    }

    @PostMapping("/add")
    public Place add(@RequestBody Place place) {
        return placeService.save(place);
    }

    @PostMapping("/edit")
    public Place update(@RequestBody Place place) {return placeService.update(place);}

    @DeleteMapping("/delete/{id}")
    public void deletePlace (@PathVariable ("id") Long id){placeService.deleteById(id);
    }
}
