package com.modu.ResourceServer;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
@Getter
public class PostRepository {

    private Map<Long, Post> postMap = new HashMap<>();

    public PostRepository() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Post post = new Post((long)i, "post" + i, "hello~" + (int)(Math.random()*10), "user");
            postMap.put((long)i, post);
            Thread.sleep(305);
        }
    }

    public Post findById(Long id) {
        return postMap.get(id);
    }

    public List<Post> findAll() {
        return postMap.values().stream().toList();
    }

    public List<Post> findByUsername(String username) {
        return postMap.values().stream()
                .filter(post -> post.getUsername().equals(username))
                .collect(Collectors.toList());
    }
}
