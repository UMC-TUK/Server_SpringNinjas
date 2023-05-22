package jaehuek.instagram.domain.comments.service;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import jaehuek.instagram.domain.comments.domain.repository.CommentRepository;
import jaehuek.instagram.domain.comments.dto.CommentCreateRequest;
import jaehuek.instagram.domain.comments.dto.CommentInfo;
import jaehuek.instagram.domain.comments.dto.CommentUpdateRequest;
import jaehuek.instagram.domain.comments.dto.mapper.CommentMapper;
import jaehuek.instagram.domain.posts.domain.entity.Post;
import jaehuek.instagram.domain.posts.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    /*
    댓글 생성
    댓글 수정
    댓글 삭제
    */

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentInfo createComment(CommentCreateRequest commentCreateRequest) {
        Post foundPost = postRepository.findById(commentCreateRequest.getPostId()).orElseThrow();
        Comment newComment = Comment.builder()
                .post(foundPost)
                .content(commentCreateRequest.getContent())
                .build();
        newComment = commentRepository.save(newComment);

        return commentMapper.mapCommentEntityToInfo(newComment);
    }

    public CommentInfo updateComment(CommentUpdateRequest commentUpdateRequest, Long commentId) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow();
        foundComment.updateCommentInfo(commentUpdateRequest);
        Comment updatedComment = commentRepository.save(foundComment);

        return commentMapper.mapCommentEntityToInfo(updatedComment);
    }

    public void deleteComment(Long commentId) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.delete(foundComment);
    }
}
