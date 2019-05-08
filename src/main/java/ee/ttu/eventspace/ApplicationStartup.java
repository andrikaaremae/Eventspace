//package ee.ttu.eventspace;
//
//import ee.ttu.eventspace.model.Role;
//import ee.ttu.eventspace.model.User;
//import ee.ttu.eventspace.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//
//    @Component
//    public class ApplicationStartup
//            implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Lazy
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    User user = new User("admin", "salasona", "System", "Admin", "admin@gmail.com", "112");
//
//
//
//    public User save(User user) {
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Collections.singletonList(Role.ROLE_ADMIN));
//        return userRepository.save(user);
//    }
//
//        @Override
//        public void onApplicationEvent(final ContextRefreshedEvent event) {
//
//           save(user);
//        }
//
//    }
