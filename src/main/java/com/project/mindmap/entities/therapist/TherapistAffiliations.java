package com.project.mindmap.entities.therapist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "therapist_affiliations")
public class TherapistAffiliations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String affiliation;

    @ManyToOne
    @JoinColumn(name = "therapist_info")
    @JsonBackReference
    private TherapistInfo therapistInfo;

    public TherapistAffiliations() {
    }

    public TherapistAffiliations(Long id, String affiliation, TherapistInfo therapistInfo) {
        this.id = id;
        this.affiliation = affiliation;
        this.therapistInfo = therapistInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public TherapistInfo getTherapistInfo() {
        return therapistInfo;
    }

    public void setTherapistInfo(TherapistInfo therapistInfo) {
        this.therapistInfo = therapistInfo;
    }
}
