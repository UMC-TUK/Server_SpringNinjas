package jaehuek.instagram.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class SignupRequest {
    private final String nickname;
    private final String password;
    private final MultipartFile profileImage;
}
