package com.modu.ResourceServer;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    private Long postId;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(Long postId, String title, String content, String username) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.username = username;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
