package com.project.mindmap.services;


import com.project.mindmap.dao.TherapistRepo;
import com.project.mindmap.dto.TherapistDTO;
import com.project.mindmap.entities.therapist.TherapistInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TherapistService {
    @Autowired
    private TherapistRepo therapistRepo;

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
