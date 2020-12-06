package com.example.web;


import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import com.example.domain.user.Role;
import com.example.domain.user.User;
import com.example.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @GetMapping("/api/v1/user")
    public SessionUser getSessionUser(@LoginUser SessionUser user){
        return user;
    }

    @GetMapping("/api/v1/logout")
    public void logout(){
        httpSession.setAttribute("sessionUser",null);
    }

    @GetMapping("/testLogin")
    public SessionUser test(){
        User build = User.builder()
                .email("px201226@gmail.com" + String.valueOf((int)(Math.random()*10000)))
                .name("이기수")
                .picture("picture")
                .role(Role.USER)
                .build();
        userRepository.save(build);
        SessionUser user = new SessionUser(build);

        httpSession.setAttribute("sessionUser", user);
        return user;
    }
}
