package ee.ttu.eventspace;

import ee.ttu.eventspace.model.Address;
import ee.ttu.eventspace.model.Booking;
import ee.ttu.eventspace.model.Place;
import ee.ttu.eventspace.model.User;
import ee.ttu.eventspace.repository.BookingRepository;
import ee.ttu.eventspace.repository.PlaceRepository;
import ee.ttu.eventspace.repository.UserRepository;
import ee.ttu.eventspace.service.BookingService;
import ee.ttu.eventspace.service.PlaceService;
import ee.ttu.eventspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;

@SpringBootApplication
public class EventspaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EventspaceApplication.class, args);
	}
}

