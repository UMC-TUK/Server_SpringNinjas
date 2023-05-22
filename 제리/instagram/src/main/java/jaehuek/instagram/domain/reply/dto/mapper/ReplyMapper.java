package jaehuek.instagram.domain.reply.dto.mapper;

import jaehuek.instagram.domain.reply.domain.entity.Reply;
import jaehuek.instagram.domain.reply.dto.ReplyInfo;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public ReplyInfo mapReplyEntityToInfo(Reply reply) {
        return ReplyInfo.builder()
                .content(reply.getContent())
                .build();
    }
}
