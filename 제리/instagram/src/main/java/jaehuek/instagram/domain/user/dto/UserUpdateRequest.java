package jaehuek.instagram.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class UserUpdateRequest {

    @NotNull
    private final String nickname;

    @NotNull
    private final String profileImage;
}
