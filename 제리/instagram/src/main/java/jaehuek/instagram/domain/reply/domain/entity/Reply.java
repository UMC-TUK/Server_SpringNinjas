package jaehuek.instagram.domain.reply.domain.entity;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import jaehuek.instagram.domain.reply.dto.ReplyUpdateRequest;
import jaehuek.instagram.domain.user.domain.entity.User;
import jaehuek.instagram.global.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Reply(Comment comment, String content, User user) {
        this.user = user;
        this.comment = comment;
        this.content = content;
    }

    public void updateReplyInfo(ReplyUpdateRequest replyUpdateRequest) {
        this.content = replyUpdateRequest.getContent();
    }
}
