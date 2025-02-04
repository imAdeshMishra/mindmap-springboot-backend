package com.project.mindmap.entities.user;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "user_credentials")
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
    private int id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Email
    private String emailId;
    private String password;

    public UserCredentials() {
    }

    public UserCredentials(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    // Constructor with userId
    public UserCredentials(String email, String password, String userId) {
        this.emailId = email;
        this.password = password;
        this.userId = userId;
    }

    // Getters and setters
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
