package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAllByCategoryAndMaxCapacityLessThanEqual(String category, Integer maxCapacity);

    List<Place> findAllByCategoryAndAddressCity(String category, String city);
}
