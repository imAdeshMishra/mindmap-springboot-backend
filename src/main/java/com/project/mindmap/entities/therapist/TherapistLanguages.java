package com.project.mindmap.entities.therapist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "therapist_languages")
public class TherapistLanguages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String language;

    @ManyToOne
    @JoinColumn(name = "therapist_info")
    @JsonBackReference
    private TherapistInfo therapistInfo;

    public TherapistLanguages() {
    }

    public TherapistLanguages(Long id, String language, TherapistInfo therapistInfo) {
        this.id = id;
        this.language = language;
        this.therapistInfo = therapistInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public TherapistInfo getTherapistInfo() {
        return therapistInfo;
    }

    public void setTherapistInfo(TherapistInfo therapistInfo) {
        this.therapistInfo = therapistInfo;
    }
}
