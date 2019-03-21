package ee.ttu.eventspace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.security.UserCredentials;
import ee.ttu.eventspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        ObjectNode token = JsonNodeFactory.instance.objectNode();
        token.put("token", userService.login(userCredentials.getUsername(), userCredentials.getPassword()));
        return token.toString();
    }

    @PostMapping("/register")
    public User register(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }
}
