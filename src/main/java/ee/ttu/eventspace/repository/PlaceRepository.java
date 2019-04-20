package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByCategoryAndMaxCapacityLessThanEqual(String category, Integer maxCapacity);

    List<Place> findByCategory(String category);

    }
