package ee.ttu.eventspace;

import ee.ttu.eventspace.model.Address;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.service.PlaceService;
import ee.ttu.eventspace.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PlaceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
    Address address1 = new Address("Estonia", "Harjumaa", "Tallinn", "Akadeemia tee", "42", "22222");
    Place place1 = new Place("A house", "Great place", 4, address1, "Wedding", user1);
    Address address2 = new Address("Estonia", "Harjumaa", "Tallinn", "Ehitajate tee", "42", "33333");
    Place place2 = new Place("Otherplace", "Great place", 4, address2, "Wedding", user1);

    @Test
    public void shouldBeRegistered() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        assertThat(placeService.findById(place1.getId())).get().isEqualTo(place1);
    }

    @Test
    public void shouldReturnSavedAddress() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        assertThat(placeService.findById(place1.getId()).get().getAddress()).isEqualTo(place1.getAddress());
    }

    @Test
    public void shouldReturnAllRegisteredPlaces() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        placeService.save(place2);
        assertThat(placeService.findAll()).hasSize(2);
    }

    @Test
    public void shouldHaveOwner() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        assertThat(placeService.findById(place1.getId()).get().getOwner().getUsername().equals("Numbaone"));
    }

    @Test
    public void shouldBeDeleted() throws Exception {
        userService.save(user1);
        placeService.save(place1);
        placeService.deleteById(place1.getId());
        assertThat(placeService.findById(place1.getId())).isEmpty();
    }
}
