package jaehuek.instagram.domain.posts.controller;


import jaehuek.instagram.domain.posts.dto.PostCreateRequest;
import jaehuek.instagram.domain.posts.dto.PostInfo;
import jaehuek.instagram.domain.posts.dto.PostUpdateRequest;
import jaehuek.instagram.domain.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;

    // @ModelAttribute를 사용하면 HTTP 요청 파라미터를 자바 객체에 자동으로 바인딩할 수 있다.
    // 일반적으로 Content-Type이 application/x-www-form-urlencoded 또는 multipart/form-data인 요청에서 사용된다.
    // @RequestBody은 HTTP 요청 body에 포함된 데이터를 자바 객체로 변환한다.
    // 주로 Content-Type이 application/json 또는 application/xml과 같은 형식을 가지는 요청에서 사용된다.

    // 여기서는 file과 string을 보내줘야 하므로 multipart/form-data를 이용했다.
    @PostMapping
    public PostInfo create(@ModelAttribute PostCreateRequest postCreateRequest) {
        return postService.createPost(postCreateRequest);
    }

    @PutMapping("/{postId}")
    public PostInfo update(@ModelAttribute PostUpdateRequest postUpdateRequest, @PathVariable Long postId) {
        return postService.updatePost(postUpdateRequest, postId);
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
