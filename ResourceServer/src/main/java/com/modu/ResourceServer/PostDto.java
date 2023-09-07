package com.modu.ResourceServer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private String title;
    private String content;
    private String username;
    private LocalDateTime updatedAt;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUsername();
        this.updatedAt = post.getUpdatedAt();
    }
}
