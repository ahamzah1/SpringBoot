package com.example.demo.Test;

public class PostDTO {
    private Long userId;
    private String title;
    private String body;
    private Long id;

    public PostDTO(Long userId, String title, Long id, String body) {
        this.userId = userId;
        this.title = title;
        this.id = id;
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
