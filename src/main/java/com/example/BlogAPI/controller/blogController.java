package com.example.BlogAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/posts")
@RestController
public class blogController {

    @GetMapping()
    public String getPosts() {
        return "Merhaba";
    }
    
}
