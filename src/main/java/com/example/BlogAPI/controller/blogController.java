package com.example.BlogAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogAPI.model.Post;
import com.example.BlogAPI.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping()
@RestController
public class blogController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public String homePage() {
        return "Welcome to my blog!";
    }

    @GetMapping("/posts")
    public Iterable<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable("id") Integer id) {
        Post post = postService.findById(id);

        if (post == null) {
            return null;
        }

        return post;

    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        Post newPost = postService.save(post);
        return newPost;
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestParam Integer id, @RequestBody Post post) {
        Post postToUpdate = postService.findById(id);

        if (postToUpdate == null) {
            return null;
        }

        postToUpdate.setAuthor(post.getAuthor());
        postToUpdate.setContent(post.getContent());
        postToUpdate.setCreatedAt(post.getCreatedAt());
        postToUpdate.setTitle(post.getTitle());

        return postToUpdate;
    }

    @DeleteMapping("/posts/{id}")
    public int deletePost(@PathVariable("id") Integer id) {
        Post postToDelete = postService.findById(id);

        if (postToDelete == null) {
            return 0;
        }

        postService.deleteById(id);
        return 0;

    }
}
