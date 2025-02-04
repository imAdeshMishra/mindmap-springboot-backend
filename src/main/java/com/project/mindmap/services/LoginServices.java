package com.project.mindmap.services;

import com.project.mindmap.dao.UserCredentialsRepo;
import com.project.mindmap.dao.UserRepo;
import com.project.mindmap.entities.user.UserCredentials;
import com.project.mindmap.entities.user.UserInfo;
import com.project.mindmap.helper.IdGenerationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class LoginServices {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    public Map<String,String> createUser(UserCredentials user) {

        if (!userRepo.existsByEmailId(user.getEmailId())){

            String uniqueUserId = IdGenerationHelper.generateUniqueUserId(); // Generate a unique userId
            UserCredentials newUserCredentials = new UserCredentials(user.getEmailId(), user.getPassword());
            newUserCredentials.setUserId(uniqueUserId);

            userCredentialsRepo.save(newUserCredentials);

            userRepo.save(new UserInfo(newUserCredentials.getEmailId(),newUserCredentials.getUserId()));

            Map<String,String> response = new HashMap<>();

            response.put("status", "success");
            response.put("userId", newUserCredentials.getUserId());

            return response;
        }else {
            Map<String,String> response = new HashMap<>();

            response.put("status", "failure");
            response.put("message", "User with email "+ user.getEmailId()+" Already exists");

            return response;
        }
    }

    public Map<String, String> loginUser(String emailId,String password){
        UserCredentials user = userCredentialsRepo.findByEmailId(emailId);
        Map<String,String> loginResponse = new HashMap<>();
        if (user!=null){
            if (Objects.equals(user.getPassword(), password)){
                loginResponse.put("email", emailId);
                loginResponse.put("userId", user.getUserId());
            }else {
                loginResponse.put("email", emailId);
                loginResponse.put("userId", "N/A");
            }
        }else{
            loginResponse.put("email", emailId);
            loginResponse.put("userId", "null");
        }

        return loginResponse;

    }

}
