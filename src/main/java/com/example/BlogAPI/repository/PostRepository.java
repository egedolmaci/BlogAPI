package com.example.BlogAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.BlogAPI.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
