package jaehuek.instagram.domain.user.domain.repository;

import jaehuek.instagram.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNickname(String username);

    Optional<User> findByNickname(String nickname);
}
