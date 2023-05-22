package jaehuek.instagram.domain.comments.domain.repository;

import jaehuek.instagram.domain.comments.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
