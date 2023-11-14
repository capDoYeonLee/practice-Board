package tony.demo.comment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.demo.comment.domain.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
