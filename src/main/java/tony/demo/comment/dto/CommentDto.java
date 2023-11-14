package tony.demo.comment.dto;

import lombok.*;
import tony.demo.comment.domain.entity.Comment;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String commentAuthor;
    private String commentContent;
    private LocalDateTime commentCreateDate;
    private LocalDateTime commentModifiedDate;

    public Comment toEntity(){
        Comment comment = Comment.builder()
                .id(id)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .build();
        return comment;
    }

    @Builder
    public CommentDto(Long id, String commentAuthor, String commentContent, LocalDateTime commentCreateDate, LocalDateTime commentModifiedDate){
        this.id = id;
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
        this.commentCreateDate = commentCreateDate;
        this.commentModifiedDate = commentModifiedDate;
    }

}
