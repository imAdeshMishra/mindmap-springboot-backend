package com.project.mindmap.dao;

import com.project.mindmap.entities.therapist.TherapistReview;
import com.project.mindmap.entities.user.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ReviewRepo extends CrudRepository<UserInfo,Integer> {
    boolean existsByReviewId(String reviewId);
    ArrayList<TherapistReview> existsByTherapistId(String therapistId);
}
