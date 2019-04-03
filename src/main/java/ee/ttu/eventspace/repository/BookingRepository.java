package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingsByPlace(Place place);
}
