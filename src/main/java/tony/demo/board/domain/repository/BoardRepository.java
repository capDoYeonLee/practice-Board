package tony.demo.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.demo.board.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
