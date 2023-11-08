package tony.demo.service;

import org.springframework.stereotype.Service;
import tony.demo.domain.entity.Board;
import tony.demo.domain.repository.BoardRepository;
import tony.demo.dto.BoardDto;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getAuthor())
                    .content(board.getContent())
                    .createdDate((board.getCreatedDate()))
                    .build();
            boardDtoList.add(boardDto); // Q.이게 지금 DTO를 통해서 데이터를 가져오고 보드디티오리스트에 데이터를 추가해서 그걸 보여주는건가?
        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id){
        Board board = boardRepository.findById(id).get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .build();
        return boardDto;
    }
    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }

}
