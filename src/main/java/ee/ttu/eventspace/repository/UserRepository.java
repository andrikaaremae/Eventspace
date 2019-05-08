package ee.ttu.eventspace.repository;

import ee.ttu.eventspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);

    User findByUsername(String username);

//    User findByUserId(Long userId);

    List<User> findAll();
}
