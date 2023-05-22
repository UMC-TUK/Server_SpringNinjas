package jaehuek.instagram.domain.reply.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReplyCreateRequest {

    private final Long commentId;

    private final String content;
}
