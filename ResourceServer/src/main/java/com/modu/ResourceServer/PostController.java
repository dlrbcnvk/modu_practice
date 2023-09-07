package com.modu.ResourceServer;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> posts(HttpServletRequest request) {

        log.info("GET /posts 컨트롤러 진입");
        return postService.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }


}
