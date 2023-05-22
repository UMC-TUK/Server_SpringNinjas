package jaehuek.instagram.domain.follow.domain.repository;

import jaehuek.instagram.domain.follow.domain.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
