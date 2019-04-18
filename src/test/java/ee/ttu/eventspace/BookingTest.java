package ee.ttu.eventspace;

import ee.ttu.eventspace.model.Address;
import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.service.BookingService;
import ee.ttu.eventspace.service.PlaceService;
import ee.ttu.eventspace.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookingTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private BookingService bookingService;

    User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
    Address address1 = new Address("Estonia", "Harjumaa", "Tallinn", "Akadeemia tee", "42", "22222");
    Place place1 = new Place("A house", "Great place", 4, address1, "Wedding", user1);
    Booking booking1 = new Booking(Date.valueOf("2019-04-04"), Date.valueOf("2019-04-05"), BigDecimal.valueOf(300));
    Booking booking2 = new Booking(Date.valueOf("2019-04-05"), Date.valueOf("2019-04-05"), BigDecimal.valueOf(300));

    @Test
    public void shouldBeConnectedToPlace() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        bookingService.save(place1.getId(), booking1);
        assertThat(bookingService.findById(booking1.getId()).getPlace()).isEqualTo(place1);
    }

    @Test
    public void shouldReturnAllBookingsConntectedToPlace() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        bookingService.save(place1.getId(), booking1);
        bookingService.save(place1.getId(), booking2);
        System.out.println(placeService.findById(place1.getId()).get().getBookings());
        System.out.println(bookingService.findBookingsByPlace(place1.getId()));
        System.out.println(bookingService.findAll());
        assertThat(bookingService.findBookingsByPlace(place1.getId())).hasSize(2);
    }
}
