package nastia.dev.somnus.repository;

import nastia.dev.somnus.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
