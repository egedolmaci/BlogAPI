package com.example.BlogAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogAPI.model.Post;
import com.example.BlogAPI.service.PostService;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping()
@RestController
public class blogController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Iterable<Post> getAllPosts() {
        return postService.findAll();
    }
}
