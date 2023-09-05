package com.modu.ResourceServer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {

    @GetMapping("/posts")
    public List<Post> posts() {
        Post post1 = PostService.getPost(1L, "산책이나 나갈까..", "ㅎㅎ", "cho");
        Post post2 = PostService.getPost(2L, "나갔다 오자!", "에휴~", "kim");

        return Arrays.asList(post1, post2);
    }
}
