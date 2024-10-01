package com.example.BlogAPI.service;

import com.example.BlogAPI.model.Post;
import com.example.BlogAPI.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post update(Integer id, Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }
}
