package com.project.mindmap.entities.therapist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "therapist_scopes")
public class TherapistScopes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private String scope;

    @ManyToOne
    @JoinColumn(name = "therapist_info")
    @JsonBackReference
    private TherapistInfo therapistInfo;

    public TherapistScopes() {
    }

    public TherapistScopes(Long id, String scope, TherapistInfo therapistInfo) {
        this.id = id;
        this.scope = scope;
        this.therapistInfo = therapistInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public TherapistInfo getTherapistInfo() {
        return therapistInfo;
    }

    public void setTherapistInfo(TherapistInfo therapistInfo) {
        this.therapistInfo = therapistInfo;
    }
}
