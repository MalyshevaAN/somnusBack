package nastia.dev.somnus.repository;

import nastia.dev.somnus.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream, Long> {
}
