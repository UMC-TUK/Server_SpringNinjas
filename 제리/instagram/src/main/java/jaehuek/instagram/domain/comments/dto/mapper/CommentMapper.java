package jaehuek.instagram.domain.comments.dto.mapper;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import jaehuek.instagram.domain.comments.dto.CommentInfo;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentInfo mapCommentEntityToInfo(Comment comment) {
        return CommentInfo.builder()
                .post(comment.getPost())
                .content(comment.getContent())
                .build();
    }
}
