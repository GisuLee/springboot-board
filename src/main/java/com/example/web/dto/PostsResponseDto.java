package com.example.web.dto;

import com.example.domain.posts.Posts;
import com.example.domain.user.User;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private User writer;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.writer = entity.getWriter();
    }
}
