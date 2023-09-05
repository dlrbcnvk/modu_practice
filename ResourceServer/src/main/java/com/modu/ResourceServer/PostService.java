package com.modu.ResourceServer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostService {

    public static Post getPost(Long postId, String title, String content, String username) {
        return Post.builder()
                .postId(postId)
                .title(title)
                .content(content)
                .username(username)
                .build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Map<String, String> getJWT() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Map.of("jwt", jwt.getSubject());
    }
}
