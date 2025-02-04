package com.project.mindmap.services;

import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.user.UserInfo;
import com.project.mindmap.entities.user.UserRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserServices {

    @Autowired
    private UserRepo userRepo;


    public Map<String,String> onBoardUser(UserInfo user){
        System.out.println(user.getUserId());
        if (userRepo.existsByUserId(user.getUserId())){

            UserInfo existingUser = userRepo.findByUserId(user.getUserId());

            // Update the fields (only those that are non-null or valid)
            if (user.getUserName() != null) existingUser.setUserName(user.getUserName());
            if (user.getUserDob() != null) existingUser.setUserDob(user.getUserDob());
            if (user.getGender() != null) existingUser.setGender(user.getGender());
            if (user.getPhoneNumber() != null) existingUser.setPhoneNumber(user.getPhoneNumber());
            if (user.getMaritalStatus() != null) existingUser.setMaritalStatus(user.getMaritalStatus());
            if (user.getUserCategory() != null) existingUser.setUserCategory(user.getUserCategory());

            // Handle userRequirements
            if (user.getUserRequirements() != null) {
                // Clear the existing collection
                existingUser.getUserRequirements().clear();

                // Add new requirements
                for (UserRequirement requirement : user.getUserRequirements()) {
                    requirement.setUserInfo(existingUser); // Set the association
                    existingUser.getUserRequirements().add(requirement);
                }
            }

            userRepo.save(existingUser);

            Map<String,String> response = new HashMap<>();

            response.put("status", "success");
            response.put("userId", existingUser.getUserId());

            return response;
        }else {
            Map<String,String> response = new HashMap<>();

            response.put("status", "failure");
            response.put("message", "User does not Exists");

            return response;
        }
    }

    public UserInfo getUserInfo(String userId) {
        System.out.println("Finding user with userId: " + userId);
        if (userRepo.existsByUserId(userId)){
            System.out.println("User found");
        }
        UserInfo user = userRepo.findByUserId(userId);
        System.out.println(user);
        if (user == null) {
            System.out.println("No user found for userId: " + userId);
        }
        return user;
    }

    public boolean updateUserInfo(UserInfo userInfo) {
        String userId = userInfo.getUserId();

        if (userRepo.existsByUserId(userId)){
            UserInfo existingUser = userRepo.findByUserId(userId);

            // Update the fields (only those that are non-null or valid)
            if (userInfo.getUserDob() != null) {
                existingUser.setUserDob(userInfo.getUserDob());
            }
            if (userInfo.getMaritalStatus() != null) {
                existingUser.setMaritalStatus(userInfo.getMaritalStatus());
            }
            if (userInfo.getUserRequirements() != null) {
                existingUser.setUserRequirements(userInfo.getUserRequirements());
            }

            // Save the updated user back to the database
            userRepo.save(existingUser);
            return true;
        }else {
            return false;
        }

    }
}
