package jaehuek.instagram.domain.reply.service;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import jaehuek.instagram.domain.comments.domain.repository.CommentRepository;
import jaehuek.instagram.domain.reply.domain.entity.Reply;
import jaehuek.instagram.domain.reply.domain.repository.ReplyRepository;
import jaehuek.instagram.domain.reply.dto.ReplyCreateRequest;
import jaehuek.instagram.domain.reply.dto.ReplyInfo;
import jaehuek.instagram.domain.reply.dto.ReplyUpdateRequest;
import jaehuek.instagram.domain.reply.dto.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;

    public ReplyInfo createReply(ReplyCreateRequest replyCreateRequest) {
        Comment foundComment = commentRepository.findById(replyCreateRequest.getCommentId()).orElseThrow();
        Reply newReply = Reply.builder()
                .comment(foundComment)
                .content(replyCreateRequest.getContent())
                .build();
        newReply = replyRepository.save(newReply);

        return replyMapper.mapReplyEntityToInfo(newReply);
    }

    public ReplyInfo updateReply(ReplyUpdateRequest replyUpdateRequest, Long replyId) {
        Reply foundReply = replyRepository.findById(replyId).orElseThrow();
        foundReply.updateReplyInfo(replyUpdateRequest);
        Reply updatedReply = replyRepository.save(foundReply);

        return replyMapper.mapReplyEntityToInfo(updatedReply);
    }

    public void deleteReply(Long replyId) {
        Reply foundReply = replyRepository.findById(replyId).orElseThrow();
        replyRepository.delete(foundReply);
    }
}
