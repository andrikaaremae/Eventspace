package ee.ttu.eventspace;

import ee.ttu.eventspace.model.User;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserRegistrationTests {

    @Autowired
    private UserService userService;

    @Test
    public void shouldReturnAllRegisteredUsers() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        User user2 = new User("Bbbb", "123456", "Other", "Guy", "test@dd.ee", "44566432");
        userService.save(user1);
        userService.save(user2);
        assertThat(userService.findAll()).hasSize(3); // including admin
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
    public void shouldRejectSameEmail() throws Exception {
        User user1 = new User("Numbaone", "123456", "Some", "Guy", "abc@dd.ee", "34566432");
        User user2 = new User("Numbatwo", "123456", "Other", "Guy", "abc@dd.ee", "44566432");
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
    public void shouldHavePhoneNumberWithoutLetters() throws Exception {
        User user1 = new User("Tester", "123456", "Some", "Guy", "abc@dd.ee", "ayylmao");
        try {
            userService.save(user1);
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(ConstraintViolationException.class);
        }
    }
}
