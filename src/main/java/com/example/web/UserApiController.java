package com.example.web;


import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    @GetMapping("/api/v1/user")
    public SessionUser getSessionUser(@LoginUser SessionUser user){
        return user;
    }
}
