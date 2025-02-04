package com.project.mindmap.services;


import com.project.mindmap.dao.TherapistRepo;
import com.project.mindmap.dto.TherapistDTO;
import com.project.mindmap.entities.therapist.TherapistInfo;
import com.project.mindmap.helper.IdGenerationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TherapistService {
    @Autowired
    private TherapistRepo therapistRepo;

    public Map<String,String> addTherapist(TherapistInfo therapistInfo){
        Map<String,String> response = new HashMap<>();

        if (therapistInfo.getEmailId()==null || Objects.equals(therapistInfo.getEmailId(), "")){
            Map<String, String> responseBody = new HashMap<>();

            responseBody.put("status", "failure");
            responseBody.put("therapistId", "N/A");
            responseBody.put("message", "EmailId of therapist not provided");

            return responseBody;
        }

        if(therapistRepo.findByEmailId(therapistInfo.getEmailId())!=null){
            therapistInfo.setTherapistId(IdGenerationHelper.generateUniqueTherapistId());
            therapistRepo.save(therapistInfo);

            response.put("status", "success");
            response.put("therapistId", therapistInfo.getTherapistId());
            response.put("message", "Therapist information saved");
        }else {
            response.put("status", "failure");
            response.put("therapistId", "N/A");
            response.put("message", "Therapist with similar provided email already exists");
        }

        return response;
    }

    public List<TherapistDTO> getAllTherapists() {
        return ((List<TherapistInfo>) therapistRepo.findAll())
                .stream()
                .map(therapist -> new TherapistDTO(
                        therapist.getTherapistId(),
                        therapist.getName(),
                        therapist.getDob(),
                        therapist.getGender(),
                        therapist.getMaritalStatus(),
                        therapist.getSpecialisation(),
                        therapist.getSubSpecialisation()
                ))
                .collect(Collectors.toList());
    }

    public TherapistInfo getTherapistInfo(String therapistId){

        System.out.println("Finding user with userId: " + therapistId);

        TherapistInfo therapistInfo = therapistRepo.findByTherapistId(therapistId);
        System.out.println(therapistInfo);
        if (therapistInfo == null) {
            System.out.println("No therapist found for therapistId: " + therapistId);
        }
        return therapistInfo;
    }
}
