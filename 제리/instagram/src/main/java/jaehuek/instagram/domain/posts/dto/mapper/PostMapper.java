package jaehuek.instagram.domain.posts.dto.mapper;

import jaehuek.instagram.domain.posts.domain.entity.Post;
import jaehuek.instagram.domain.posts.dto.PostInfo;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostInfo mapPostEntityToInfo(Post post) {
        return PostInfo.builder()
                .content(post.getContent())
                .ImageUrl(post.getImageUrl())
                .build();
    }
}
