package com.example.web;


import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import com.example.service.posts.PostsService;
import com.example.web.dto.PostsResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {


    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("user", user);
        }

        return "index";
    }


    @GetMapping("/posts/save")
    public String postSave(@LoginUser SessionUser user, Model model) throws JsonProcessingException {
        if(user != null){
            model.addAttribute("user", new ObjectMapper().writeValueAsString(user));
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, @LoginUser SessionUser user, Model model) throws JsonProcessingException {
        PostsResponseDto responseDto = postsService.findById(id);
        model.addAttribute("post", responseDto);
        if(user != null){
            model.addAttribute("user", new ObjectMapper().writeValueAsString(user));
        }

        return "posts-update";
    }
}
