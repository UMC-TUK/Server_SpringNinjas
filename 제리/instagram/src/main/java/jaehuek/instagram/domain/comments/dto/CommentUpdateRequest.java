package jaehuek.instagram.domain.comments.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class CommentUpdateRequest {
    private final String content;

    public CommentUpdateRequest() {
        this.content = null;
    }
}
