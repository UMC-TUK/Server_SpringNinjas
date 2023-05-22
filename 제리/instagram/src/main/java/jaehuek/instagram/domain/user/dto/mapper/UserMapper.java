package jaehuek.instagram.domain.user.dto.mapper;

import jaehuek.instagram.domain.user.domain.entity.User;
import jaehuek.instagram.domain.user.dto.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserInfo UserEntityToInfo(User user) {
        return UserInfo.builder()
                .nickname(user.getNickname())
                .profileImage(user.getProfileImage())
                .build();
    }
}
