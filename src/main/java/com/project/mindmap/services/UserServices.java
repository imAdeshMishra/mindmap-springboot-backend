package com.project.mindmap.services;

import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServices {

    @Autowired
    private UserRepo userRepo;

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
