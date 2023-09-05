package com.modu.ResourceServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public ResponseEntity<Message> home() {
        return new ResponseEntity<>(new Message("GET / 요청은 토큰이 없어도 가져올 수 있도록 설정했습니다."), HttpStatus.OK);
    }

//    @GetMapping("/hello")
//    public Map<String, String> getJWT(@AuthenticationPrincipal Jwt jwt) {
//        return Map.of("jwt", jwt.getSubject());
//    }

    @GetMapping("/hello")
    public Map<String, String> getJWT(@AuthenticationPrincipal Jwt jwt) {
        return postService.getJWT();
    }

    @Data
    @AllArgsConstructor
    public class Message {
        String message;
    }
}
