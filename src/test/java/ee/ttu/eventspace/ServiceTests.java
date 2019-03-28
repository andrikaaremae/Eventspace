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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private BookingService bookingService;

    @Test
    public void shouldReturnAllRegisteredUsers() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        User user2 = new User("Bbbb", "123456", "Other", "Guy", "test@dd.ee", "44566432");
        userService.save(user1);
        userService.save(user2);
        assertThat(userService.findAll()).hasSize(2);
    }

    @Test
    public void shouldRejectSameUsername() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        User user2 = new User("Numbaone", "123456", "Other", "Guy", "test@dd.ee", "44566432");
        userService.save(user1);
        try {
            userService.save(user2);
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(DataIntegrityViolationException.class);
        }
    }

    @Test
    public void shouldHaveUsernameLongerThan4Chars() throws Exception {
        User user1 = new User("abc", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        try {
            userService.save(user1);
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(ConstraintViolationException.class);
        }
    }

    @Test
    public void shouldReturnAllRegisteredPlaces() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        userService.save(user1);
        Address address1 = new Address("Estonia", "Harjumaa", "Tallinn", "Akadeemia tee", "42", "22222");
        Place place1 = new Place("A house", "Great place", 4, address1, "Wedding", user1);
        Address address2 = new Address("Estonia", "Harjumaa", "Tallinn", "Ehitajate tee", "42", "33333");
        Place place2 = new Place("Otherplace", "Great place", 4, address2, "Wedding", user1);
        placeService.save(place1);
        placeService.save(place2);
        assertThat(placeService.findAll()).hasSize(2);
    }

    @Test
    public void shouldBeOwnerOfPlace() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        userService.save(user1);
        Address address1 = new Address("Estonia", "Harjumaa", "Tallinn", "Akadeemia tee", "42", "22222");
        Place place1 = new Place("A house", "Great place", 4, address1, "Wedding", user1);
        placeService.save(place1);
        assertThat(placeService.findById(1L).get().getOwner().getUsername().equals("Numbaone"));
    }

    @Test
    public void shouldBePlaceForBooking() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        userService.save(user1);
        Address address1 = new Address("Estonia", "Harjumaa", "Tallinn", "Akadeemia tee", "42", "22222");
        Place place1 = new Place("A house", "Great place", 4, address1, "Wedding", user1);
        placeService.save(place1);
        Booking booking1 = new Booking(Date.valueOf("2019-04-04"), BigDecimal.valueOf(300));
        bookingService.save(place1.getId(), booking1);
        assertThat(bookingService.findBookingsByPlace(1L)).hasSize(1);
    }
}
