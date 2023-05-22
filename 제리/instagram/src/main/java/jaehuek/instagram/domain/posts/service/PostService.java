package jaehuek.instagram.domain.posts.service;

import jaehuek.instagram.domain.posts.domain.entity.Post;
import jaehuek.instagram.domain.posts.domain.repository.PostRepository;
import jaehuek.instagram.domain.posts.dto.PostCreateRequest;
import jaehuek.instagram.domain.posts.dto.PostInfo;
import jaehuek.instagram.domain.posts.dto.PostUpdateRequest;
import jaehuek.instagram.domain.posts.dto.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    /*
    게시글 생성
    게시글 수정
    게시글 삭제
    */

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostInfo createPost(PostCreateRequest postCreateRequest) {
        Post newPost = Post.builder()
                .content(postCreateRequest.getContent())
                .imageUrl(postCreateRequest.getImageFile().getOriginalFilename())
                .build();
        newPost = postRepository.save(newPost);

        return postMapper.mapPostEntityToInfo(newPost);
    }

    public PostInfo updatePost(PostUpdateRequest postUpdateRequest, Long postId) {
        Post foundPost = postRepository.findById(postId).orElseThrow();
        foundPost.updatePostInfo(postUpdateRequest);
        Post updatedPost = postRepository.save(foundPost);

        return postMapper.mapPostEntityToInfo(updatedPost);
    }

    public void deletePost(Long postId) {
        Post foundPost = postRepository.findById(postId).orElseThrow();
        postRepository.delete(foundPost);
    }
}
