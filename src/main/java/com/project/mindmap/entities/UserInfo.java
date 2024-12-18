package com.project.mindmap.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
    private int id; // Follow Java naming conventions

    @Column(unique = true, nullable = false) // Ensure non-nullable unique field
    private String userId;

    private String userName;
    private String userDob;
    private String gender;

    @Email
    @Column(unique = true, nullable = false) // Ensure non-nullable unique field
    private String emailId;

    private String phoneNumber;
    private String password;

    // Default constructor
    public UserInfo() {
    }

    // Constructor for full details
    public UserInfo(int id, String userName, String userDob, String gender, String emailId, String phoneNumber, String password) {
        this.id = id;
        this.userName = userName;
        this.userDob = userDob;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Constructor for creating a user with email and password only
    public UserInfo(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
