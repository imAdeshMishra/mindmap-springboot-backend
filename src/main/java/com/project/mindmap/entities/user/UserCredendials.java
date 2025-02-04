package com.project.mindmap.entities.user;
import jakarta.validation.constraints.Email;


public class UserCredendials {
    @Email
    private String email;
    private String password;
    private String userId; // New field

    public UserCredendials() {
    }

    public UserCredendials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Constructor with userId
    public UserCredendials(String email, String password, String userId) {
        this.email = email;
        this.password = password;
        this.userId = userId;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
