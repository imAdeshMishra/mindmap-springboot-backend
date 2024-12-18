package com.project.mindmap.controllers;

import com.project.mindmap.entities.UserCredendials;
import com.project.mindmap.entities.UserInfo;
import com.project.mindmap.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginServices loginServices;

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> home(){
        System.out.println("home request accepted");
        Map<String,String> response = new HashMap<>();

        response.put("status", "success");
        response.put("message", "Hello from mindmap server");
//        response.put("testing", "HIHIHAHAHAHAHAHAHA");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }


    @PostMapping("/users/create-user")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody UserCredendials userCredendials){
        System.out.println("create-user request accepted");
        try{
            Map<String, String> responseBody = loginServices.createUser(userCredendials);

            if (responseBody.containsValue("success")){
                System.out.println("user created");
                return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
            }else {
                System.out.println("user not created");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseBody);
            }

        }catch (Exception e){
            System.out.println("user not created");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/users/update-user")
    public ResponseEntity<Map<String, Object>> updateUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println("update-user request accepted");
        try {
            boolean isUpdated = this.loginServices.updateUserInfo(userInfo);

            if (isUpdated) {
                // Create a success response body
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("status", "success");
                responseBody.put("userId", userInfo.getUserId());


                // Return status code 201 with the response body
                return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
            } else {
                // Create a failure response body
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("status", "failure");
                responseBody.put("message", "User does not exist");

                // Return status code 205 with the response body
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseBody);
            }
        } catch (Exception e) {
            // Handle unexpected errors with status 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
