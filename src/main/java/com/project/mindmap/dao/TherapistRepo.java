package com.project.mindmap.dao;

import com.project.mindmap.entities.therapist.TherapistInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TherapistRepo extends CrudRepository<TherapistInfo,Integer> {
    TherapistInfo findByTherapistId(String therapistId);
    TherapistInfo findByEmailId(String emailId);
}
