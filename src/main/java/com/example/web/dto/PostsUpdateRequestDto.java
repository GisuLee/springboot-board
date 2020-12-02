package com.example.web.dto;


import com.example.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;
    private User sessionUser;

    @Builder
    public PostsUpdateRequestDto(String title, String content, User sessionUser){
        this.title = title;
        this.content = content;
        this.sessionUser = sessionUser;
    }
}
