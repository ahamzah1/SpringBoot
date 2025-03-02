package com.example.demo.Security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    public String username;
    @Column(nullable = false)
    public String role;

    @Column(nullable = false)
    public String password;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Users{" +
                "password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

