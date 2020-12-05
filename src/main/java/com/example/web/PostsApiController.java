package com.example.web;


import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import com.example.service.posts.PostsService;
import com.example.web.dto.PostsListResponseDto;
import com.example.web.dto.PostsResponseDto;
import com.example.web.dto.PostsSaveRequestDto;
import com.example.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts")
    public List<PostsListResponseDto> getList(){
        return postsService.findAllDesc();
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto, @LoginUser SessionUser user){
        return postsService.save(requestDto, user.getEmail());
    }

    @PutMapping("/api/v1/posts/{postId}")
    public Long update(@PathVariable Long postId, @LoginUser SessionUser user, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(postId, user.getEmail(), requestDto);
    }

    @GetMapping("/api/v1/posts/{postId}")
    public PostsResponseDto findById(@PathVariable Long postId){
        System.out.println("findByid:" + postId);
        return postsService.findById(postId);
    }

    @DeleteMapping("/api/v1/posts/{postId}")
    public Long delete(@PathVariable Long postId, @LoginUser SessionUser user){
        postsService.delete(postId,user.getEmail());
        return postId;
    }
}
