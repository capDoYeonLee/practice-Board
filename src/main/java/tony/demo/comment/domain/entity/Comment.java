package tony.demo.comment.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length=10, nullable = false)
    private String commentAuthor;

    @Column(length = 100, nullable = false)
    private String commentContent;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime commentCreateDate;

    @LastModifiedDate
    private LocalDateTime commentModifiedDate;

    @Builder
    public Comment(Long id, String commentAuthor, String commentContent){
        this.id = id;
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
    }
}
