package jaehuek.instagram.domain.posts.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class PostInfo {
    private String content;
    private String ImageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostInfo postInfo = (PostInfo) o;
        return Objects.equals(getContent(), postInfo.getContent()) && Objects.equals(getImageUrl(), postInfo.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent(), getImageUrl());
    }
}
