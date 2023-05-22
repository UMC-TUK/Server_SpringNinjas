package jaehuek.instagram.domain.posts.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class PostCreateRequest {

    private final String content;

    private final MultipartFile imageFile;
}
