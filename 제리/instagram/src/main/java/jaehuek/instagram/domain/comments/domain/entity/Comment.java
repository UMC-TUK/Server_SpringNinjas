package jaehuek.instagram.domain.comments.domain.entity;

import jaehuek.instagram.domain.comments.dto.CommentUpdateRequest;
import jaehuek.instagram.domain.posts.domain.entity.Post;
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
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(Post post, String content, User user) {
        this.user = user;
        this.post = post;
        this.content = content;
    }

    public void updateCommentInfo(CommentUpdateRequest commentUpdateRequest) {
        this.content = commentUpdateRequest.getContent();
    }
}
