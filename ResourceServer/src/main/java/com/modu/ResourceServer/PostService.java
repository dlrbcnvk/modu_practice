package com.modu.ResourceServer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository repository;

    public Post findById(Long id) {
        return repository.getPostMap().get(id);
    }

    public List<Post> findAll() {
        return repository.findAll();
    }
}
