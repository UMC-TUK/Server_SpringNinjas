package jaehuek.instagram.domain.comments.controller;

import jaehuek.instagram.domain.comments.dto.CommentCreateRequest;
import jaehuek.instagram.domain.comments.dto.CommentInfo;
import jaehuek.instagram.domain.comments.dto.CommentUpdateRequest;
import jaehuek.instagram.domain.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentInfo create(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createComment(commentCreateRequest);
    }

    @PatchMapping("/{commentId}")
    public CommentInfo update(@RequestBody CommentUpdateRequest commentUpdateRequest, @PathVariable Long commentId) {
        return commentService.updateComment(commentUpdateRequest, commentId);
    }

    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
