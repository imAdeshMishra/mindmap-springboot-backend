package com.project.mindmap.controllers;

import com.project.mindmap.dto.TherapistDTO;
import com.project.mindmap.entities.therapist.TherapistInfo;
import com.project.mindmap.services.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TherapistController {


    @Autowired
    private TherapistService therapistService;

    @GetMapping("therapist/get-therapists-list")
    public ResponseEntity<Map<String,Object>> getTherapistsList(){
        try{
            List<TherapistDTO> therapists = therapistService.getAllTherapists();
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", therapists);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println("Internal Server Error");
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("therapist/get-therapist-info")
    public ResponseEntity<Map<String,Object>> getTherapistInfo(String therapistId){
        try{
            TherapistInfo therapistInfo = therapistService.getTherapistInfo(therapistId);

            Map<String, Object> response = new HashMap<>();

            if(therapistInfo!=null){
                response.put("status", "success");
                response.put("data", therapistInfo);
                return ResponseEntity.ok(response);
            }else{
                response.put("status","failure");
                response.put("message","therapist not found");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
            }
        } catch (Exception e) {
            System.out.println("Internal Server Error");
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
