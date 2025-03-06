package com.example.demo.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public PostDTO hello(@PathVariable Long id){
        return postService.getPost(id);
    }

    @GetMapping
    public List<PostDTO> getPosts(){
        return postService.getPosts();
    }
}
