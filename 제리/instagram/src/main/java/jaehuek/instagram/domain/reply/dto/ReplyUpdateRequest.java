package jaehuek.instagram.domain.reply.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReplyUpdateRequest {

    private final String content;
}
