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
public class EventspaceApplication implements CommandLineRunner {

	@Autowired
	private PlaceService placeService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	public static void main(String[] args) {
		SpringApplication.run(EventspaceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// *** URL below needs to match the Vue client URL and port ***
		config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
		config.setAllowedOrigins(Collections.singletonList("http://localhost:8081"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	//For testing
	@Override
	public void run(String... args) throws Exception {
//		Place place = new Place("Name?", "A house.", new Address("Estonia", "Harjumaa",
//				"Tallinn", "Ehitajate tee", "5", "12616"));
//
//		Booking booking = new Booking(Date.valueOf(LocalDate.of(2019, 2, 22)), Date.valueOf(LocalDate.of(2019, 2, 23)),
//				BigDecimal.valueOf(300L));
//		Booking booking2 = new Booking(Date.valueOf(LocalDate.of(2019, 2, 22)), Date.valueOf(LocalDate.of(2019, 2, 23)),
//				BigDecimal.valueOf(300L));
//
//		placeService.save(place);
//		bookingService.save(place, booking);
//		bookingService.save(place, booking2);
	}
}

