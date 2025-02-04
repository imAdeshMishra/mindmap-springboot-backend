package com.project.mindmap.entities.therapist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.mindmap.entities.user.UserInfo;
import jakarta.persistence.*;

@Entity
@Table(name="therapist_reviews")
public class TherapistReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
    private int id; // Follow Java naming conventions

    @Column(unique = true, nullable = false) // Ensure non-nullable unique field
    private String reviewId;

    private String reviewerName;
    private String reviewDate;
    private int stars;

    @ManyToOne
    @JoinColumn(name = "therapist_info")
    @JsonBackReference
    private TherapistInfo therapistInfo;

    @ManyToOne
    @JoinColumn(name = "user_info")
    @JsonBackReference
    private UserInfo userInfo;

}
