package jaehuek.instagram.domain.comments.dto;

import jaehuek.instagram.domain.posts.domain.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class CommentInfo {
    private Post post;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentInfo that = (CommentInfo) o;
        return Objects.equals(getPost(), that.getPost()) && Objects.equals(getContent(), that.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPost(), getContent());
    }
}
