package jaehuek.instagram.domain.posts.domain.entity;

import jaehuek.instagram.domain.posts.dto.PostUpdateRequest;
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
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String content, String imageUrl, User user) {
        this.user = user;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public void updatePostInfo(PostUpdateRequest postUpdateRequest) {
        this.content = postUpdateRequest.getContent();
        this.imageUrl = postUpdateRequest.getImageFile().getOriginalFilename();
    }
}
