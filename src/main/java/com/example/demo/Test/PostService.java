package com.example.demo.Test;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private static String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    private RestTemplate restTemplate = new RestTemplate();

    public PostDTO getPost(Long id){
        ResponseEntity<PostDTO> res = restTemplate.getForEntity(POST_URL + "/" + id, PostDTO.class);
        return res.getBody();
    }

    public List<PostDTO> getPosts() {
        ResponseEntity<List> res = restTemplate.getForEntity(POST_URL , List.class);
        return res.getBody();
    }
}
