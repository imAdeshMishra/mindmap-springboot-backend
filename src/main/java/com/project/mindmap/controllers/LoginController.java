package com.project.mindmap.controllers;

import com.project.mindmap.entities.user.UserCredentials;
import com.project.mindmap.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
public class LoginController {
    @Autowired
    private LoginServices loginServices;


    @PostMapping("/users/create-user/")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody UserCredentials userCredentials){
        System.out.println("create-user request accepted");
        try{
            Map<String, String> responseBody = loginServices.createUser(userCredentials);

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

    @GetMapping("/user/login-user")
    public ResponseEntity<Map<String,String>> loginUser(@RequestParam("emailId") String emailId, @RequestParam("password") String password){
        try{
            Map<String,String> loginUser = loginServices.loginUser(emailId,password);
            Map<String,String> response= new HashMap<>();

            boolean userExists = !Objects.equals(loginUser.get("userId"), "null");
            String userId = loginUser.get("userId");

            response.put("emailId", emailId);
            response.put("userId", userId);

            if (userExists){

                if (!Objects.equals(userId, "N/A")) {
                    response.put("status", "success");
                    response.put("message", "login successful");
                } else {
                    response.put("status", "success");
                    response.put("message", "Incorrect Password");
                }

                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else {
                System.out.println("user not found");
                response.put("status","success");
                response.put("message","User with provided email does not exist");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
            }

        }catch (Exception e){
            System.out.println("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
