package jaehuek.instagram.domain.reply.dto;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class ReplyInfo {

    private Comment comment;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyInfo replyInfo = (ReplyInfo) o;
        return Objects.equals(getComment(), replyInfo.getComment()) && Objects.equals(getContent(), replyInfo.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComment(), getContent());
    }
}
