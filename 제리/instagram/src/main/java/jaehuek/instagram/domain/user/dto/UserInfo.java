package jaehuek.instagram.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
public class UserInfo {
    private String nickname;
    private String profileImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(getNickname(), userInfo.getNickname()) && Objects.equals(getProfileImage(), userInfo.getProfileImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNickname(), getProfileImage());
    }
}
