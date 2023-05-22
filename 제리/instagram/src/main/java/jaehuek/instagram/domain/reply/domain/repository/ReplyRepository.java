package jaehuek.instagram.domain.reply.domain.repository;

import jaehuek.instagram.domain.reply.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
