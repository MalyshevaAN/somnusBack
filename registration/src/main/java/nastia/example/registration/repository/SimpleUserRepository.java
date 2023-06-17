package nastia.example.registration.repository;

import nastia.example.registration.model.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {
    Optional<SimpleUser> findByEmail(String email);

}
