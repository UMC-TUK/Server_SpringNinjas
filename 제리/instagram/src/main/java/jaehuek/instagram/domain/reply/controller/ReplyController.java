package jaehuek.instagram.domain.reply.controller;

import jaehuek.instagram.domain.reply.dto.ReplyCreateRequest;
import jaehuek.instagram.domain.reply.dto.ReplyInfo;
import jaehuek.instagram.domain.reply.dto.ReplyUpdateRequest;
import jaehuek.instagram.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reply")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public ReplyInfo create(ReplyCreateRequest replyCreateRequest) {
        return replyService.createReply(replyCreateRequest);
    }

    @PutMapping("/{replyId}")
    public ReplyInfo update(@RequestBody ReplyUpdateRequest replyUpdateRequest, @PathVariable Long replyId) {
        return replyService.updateReply(replyUpdateRequest, replyId);
    }

    @DeleteMapping("/{replyId}")
    public void delete(@PathVariable Long replyId) {
        replyService.deleteReply(replyId);
    }
}
