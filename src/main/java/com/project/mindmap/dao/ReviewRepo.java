package com.project.mindmap.dao;

import com.project.mindmap.entities.therapist.TherapistReview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<TherapistReview,Integer> {
    boolean existsByReviewId(String reviewId);
    // Find all reviews for a specific therapist
    List<TherapistReview> findByTherapistInfo_TherapistId(String therapistId);

    // Find all reviews given by a specific user
    List<TherapistReview> findByUserInfo_UserId(String userId);
}
