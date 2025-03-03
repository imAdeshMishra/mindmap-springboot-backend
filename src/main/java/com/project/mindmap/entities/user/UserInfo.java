package com.project.mindmap.entities.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.mindmap.entities.therapist.TherapistReview;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
    private int id;

    @Column(unique = true, nullable = false)
    private String userId;

    private String userName;
    private String userDob;
    private String gender;
    private String maritalStatus;
    private String userCategory;
    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UserRequirement> userRequirements = new ArrayList<>();


    @Email
    @Column(unique = true, nullable = false)
    private String emailId;

    private String phoneNumber;
//    private String password;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TherapistReview> therapistReviews = new ArrayList<>();



    // Default constructor
    public UserInfo() {
    }

    // Constructor for full details
    public UserInfo(int id,String userId, String userName, String userDob, String gender, String emailId, String phoneNumber,String maritalStatus,String userCategory,List<UserRequirement> userRequirements,List<TherapistReview> therapistReviews) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userDob = userDob;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.maritalStatus=maritalStatus;
        this.userCategory=userCategory;
        this.userRequirements=userRequirements;
        this.therapistReviews=therapistReviews;
    }

//     Constructor for creating a user with email and userId only
    public UserInfo(String emailId, String userId) {
        this.emailId = emailId;
        this.userId = userId;
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

    public List<UserRequirement> getUserRequirements() {
        return userRequirements;
    }

    public void setUserRequirements(List<UserRequirement> userRequirements) {
        this.userRequirements = userRequirements;
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

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public List<TherapistReview> getTherapistReviews() {
        return therapistReviews;
    }

    public void setTherapistReviews(List<TherapistReview> therapistReviews) {
        this.therapistReviews = therapistReviews;
    }
}