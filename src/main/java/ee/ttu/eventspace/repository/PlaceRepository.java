package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByCategory(String category);

    List<Place> findByCategoryAndAddressCity(String category, String city);

    @Query("SELECT DISTINCT p.address.city FROM Place p WHERE p.category = ?1")
    List<String> findDistinctCitiesWithCategory(String category);

}
