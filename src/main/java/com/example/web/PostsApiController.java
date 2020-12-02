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
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @LoginUser SessionUser user, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, user.getId(), requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id, @LoginUser SessionUser user){
        System.out.println("dddd" + user.getId());
        postsService.delete(id,user.getId());
        return id;
    }
}
