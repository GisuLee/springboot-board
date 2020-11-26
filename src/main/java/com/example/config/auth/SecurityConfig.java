package com.example.config.auth;


import com.example.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests()                                            //권한부여 설정 진입
            .antMatchers("/", "/css/**", "/images/**",
                    "/js/**", "/h2-console/**", "/profile").permitAll()     //이 주소는 전체 열람 가능
            .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //api는 사용자만 가능
            .anyRequest().authenticated()                                   //나머지 주소는 인증된 사용자들만
            .and()
            .logout()                                                       //로그아웃 설정 진입점
            .logoutSuccessUrl("/")                                          //로그아웃시 "/"로 이동
            .and()
            .oauth2Login()                                                  //oauth2 설정진입
            .userInfoEndpoint()                                             //oauth2 로그인 성공 이후 설정
            .userService(customOAuth2UserService);                          //로그인 성공 시 userService 실행
    }
}
