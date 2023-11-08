package tony.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.demo.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
