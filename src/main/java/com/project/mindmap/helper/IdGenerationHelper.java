package com.project.mindmap.helper;

import com.project.mindmap.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class IdGenerationHelper {
    @Autowired
    private static UserRepo userRepo;

    public static String generateUniqueUserId() {
        String userId;
        do {
            int randomNum = (int) (Math.random() * 9000) + 1000; // Generate a 4-digit random number
            userId = "user" + randomNum;
        } while (userRepo.existsByUserId(userId)); // Check uniqueness
        return userId;
    }

    public static String generateUniqueTherapistId() {
        String userId;
        do {
            int randomNum = (int) (Math.random() * 9000) + 1000; // Generate a 4-digit random number
            userId = "trp" + randomNum;
        } while (userRepo.existsByUserId(userId)); // Check uniqueness
        return userId;
    }

    public static String generateUniqueReviewId() {
        String userId;
        do {
            int randomNum = (int) (Math.random() * 9000) + 1000; // Generate a 4-digit random number
            userId = "rev" + randomNum;
        } while (userRepo.existsByUserId(userId)); // Check uniqueness
        return userId;
    }
}
