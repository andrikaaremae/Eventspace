package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.Rating;
import ee.ttu.eventspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findRatingsByUser(User customer);
}
