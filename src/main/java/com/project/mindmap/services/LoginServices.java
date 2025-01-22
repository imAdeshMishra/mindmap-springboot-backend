package com.project.mindmap.services;

import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.UserCredendials;
import com.project.mindmap.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginServices {
    @Autowired
    private UserRepo userRepo;

    public Map<String,String> createUser(UserCredendials user) {

        if (!userRepo.existsByEmailId(user.getEmail())){

            String uniqueUserId = generateUniqueUserId(); // Generate a unique userId
            UserInfo newUser = new UserInfo(user.getEmail(), user.getPassword());
            newUser.setUserId(uniqueUserId); // Set userId

            userRepo.save(newUser); // Save the user

            Map<String,String> response = new HashMap<>();

            response.put("status", "success");
            response.put("userId", newUser.getUserId());

            return response;
        }else {
            Map<String,String> response = new HashMap<>();

            response.put("status", "failure");
            response.put("message", "User with email "+ user.getEmail()+" Already exists");

            return response;
        }
    }



    private String generateUniqueUserId() {
        String userId;
        do {
            int randomNum = (int) (Math.random() * 9000) + 1000; // Generate a 4-digit random number
            userId = "user" + randomNum;
        } while (userRepo.existsByUserId(userId)); // Check uniqueness
        return userId;
    }
}
