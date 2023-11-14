package tony.demo.board.service;

import org.springframework.stereotype.Service;
import tony.demo.board.domain.entity.Board;
import tony.demo.board.domain.repository.BoardRepository;
import tony.demo.board.dto.BoardDto;

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

    @Transactional  //추후의 데이터를 이런 방식으로 가져온다면 방대한 양의 데이터를 가져올 때, 많은 시간이 소요되지 않을까?
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
