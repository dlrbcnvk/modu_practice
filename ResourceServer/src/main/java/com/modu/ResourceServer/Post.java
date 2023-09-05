package com.modu.ResourceServer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {

    private Long postId;
    private String title;
    private String content;
    private String username;
}
