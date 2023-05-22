package jaehuek.instagram.domain.comments.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreateRequest {

    private final Long postId;

    private final String content;
}
