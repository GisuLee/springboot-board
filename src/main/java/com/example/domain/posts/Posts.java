package com.example.domain.posts;


import com.example.domain.BaseTimeEntity;
import com.example.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @Builder
    public Posts(String title, String content, String author, User writer){
        this.title = title;
        this.content = content;
        this.author = author;
        this.writer = writer;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
