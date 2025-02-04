package com.project.mindmap.services;

import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.user.UserCredendials;
import com.project.mindmap.entities.user.UserInfo;
import com.project.mindmap.helper.IdGenerationHelper;
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

            String uniqueUserId = IdGenerationHelper.generateUniqueUserId(); // Generate a unique userId
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

}
