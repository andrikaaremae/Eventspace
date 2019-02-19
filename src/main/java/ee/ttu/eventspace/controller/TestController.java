package ee.ttu.eventspace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String getHello() {
        return "Find your perfect event space";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "This controller is " + this;
    }
}
