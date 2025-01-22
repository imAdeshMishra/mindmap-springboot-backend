package com.project.mindmap.controllers;

import com.project.mindmap.entities.UserCredendials;
import com.project.mindmap.entities.UserInfo;
import com.project.mindmap.services.LoginServices;
import com.project.mindmap.services.OnboardingService;
import com.project.mindmap.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    OnboardingService onboardingService;

    @Autowired
    private LoginServices loginServices;

    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> home(){
        System.out.println("home request accepted");
        Map<String,String> response = new HashMap<>();

        response.put("status", "success");
        response.put("message", "Hello from mindmap server");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping("/users/create-user/")
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

    @PostMapping("/users/onboard-user/")
    public ResponseEntity<Map<String, String>> onboardUser (@RequestBody UserInfo user){
        System.out.println("/users/onboard-user");
        Map<String, String> responseBody = onboardingService.onBoardUser(user);

        if (responseBody.containsValue("success")){
            System.out.println("user info saved");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
        }else {
            System.out.println("user not created");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseBody);
        }
    }

    @PutMapping("/users/update-user")
    public ResponseEntity<Map<String, Object>> updateUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println("update-user request accepted");
        try {
            boolean isUpdated = userServices.updateUserInfo(userInfo);

            Map<String, Object> responseBody = new HashMap<>();
            if (isUpdated) {
                // Create a success response body
                responseBody.put("status", "success");
                responseBody.put("userId", userInfo.getUserId());
                // Return status code 201 with the response body
                return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
            } else {
                // Create a failure response body
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

    @GetMapping("/users/get-user-info/")
    public ResponseEntity<Map<String, Object>> getUserInfo(@RequestParam("userId") String userId){
        System.out.println("get-user-info request accepted");
        try{
            UserInfo userInfo = userServices.getUserInfo(userId);
            Map<String,Object> response= new HashMap<>();

            if (userInfo!=null){
                System.out.println("user found");
                response.put("status","success");
                response.put("userInfo",userInfo);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else {
                System.out.println("user not created");
                response.put("status","failure");
                response.put("message","user not found");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
            }

        }catch (Exception e){
            System.out.println("user not found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
