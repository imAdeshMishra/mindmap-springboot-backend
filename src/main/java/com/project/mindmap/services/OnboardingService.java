package com.project.mindmap.services;

import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.user.UserInfo;
import com.project.mindmap.entities.user.UserRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class OnboardingService {

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

}
