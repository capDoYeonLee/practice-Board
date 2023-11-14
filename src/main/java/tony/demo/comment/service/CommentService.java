package tony.demo.comment.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import tony.demo.comment.domain.entity.Comment;
import tony.demo.comment.domain.repository.CommentRepository;
import tony.demo.comment.dto.CommentDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Transactional
    public List<CommentDto> getCommentList(){
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();

        for(Comment comment : commentList){
            CommentDto commentDto = CommentDto.builder()
                    .id(comment.getId())
                    .commentAuthor(comment.getCommentAuthor())
                    .commentContent(comment.getCommentContent())
                    .build();
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }

    @Transactional
    public Long saveComment(@NotNull CommentDto commentDto){
        return commentRepository.save(commentDto.toEntity()).getId();
    }

}
