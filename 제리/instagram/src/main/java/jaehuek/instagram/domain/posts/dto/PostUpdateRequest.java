package jaehuek.instagram.domain.posts.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class PostUpdateRequest {
    private final String content;
    private final MultipartFile imageFile;
}
