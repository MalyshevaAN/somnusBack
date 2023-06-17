package nastia.dev.somnus.repository;

import nastia.dev.somnus.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
