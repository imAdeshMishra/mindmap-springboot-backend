package com.project.mindmap.entities.therapist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "therapist_info")
public class TherapistInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
    private int id;

    @Column(unique = true, nullable = false)
    private String therapistId;

    private String name;
    private String dob;
    private String gender;
    private String maritalStatus;
    private String specialisation;
    private String subSpecialisation;
    private String aboutTherapist;

    @OneToMany(mappedBy = "therapistInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<TherapistLanguages> languages = new ArrayList<>();

    @OneToMany(mappedBy = "therapistInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<TherapistAffiliations> affiliations = new ArrayList<>();

    @OneToMany(mappedBy = "therapistInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<TherapistScopes> scopes = new ArrayList<>();

    @OneToMany(mappedBy = "therapistInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<TherapistServices> services = new ArrayList<>();

    @OneToMany(mappedBy = "therapistInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ArrayList<TherapistReview> reviews = new ArrayList<>();

    public TherapistInfo() {
    }

    public TherapistInfo(int id, String therapistId, String name, String dob, String gender, String maritalStatus, String specialisation, String subSpecialisation, String aboutTherapist, ArrayList<TherapistLanguages> languages, ArrayList<TherapistAffiliations> affiliations, ArrayList<TherapistScopes> scopes, ArrayList<TherapistServices> services, ArrayList<TherapistReview> reviews) {
        this.id = id;
        this.therapistId = therapistId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.specialisation = specialisation;
        this.subSpecialisation = subSpecialisation;
        this.aboutTherapist = aboutTherapist;
        this.languages = languages;
        this.affiliations = affiliations;
        this.scopes = scopes;
        this.services = services;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(String therapistId) {
        this.therapistId = therapistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getSubSpecialisation() {
        return subSpecialisation;
    }

    public void setSubSpecialisation(String subSpecialisation) {
        this.subSpecialisation = subSpecialisation;
    }

    public String getAboutTherapist() {
        return aboutTherapist;
    }

    public void setAboutTherapist(String aboutTherapist) {
        this.aboutTherapist = aboutTherapist;
    }

    public ArrayList<TherapistLanguages> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<TherapistLanguages> languages) {
        this.languages = languages;
    }

    public ArrayList<TherapistAffiliations> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(ArrayList<TherapistAffiliations> affiliations) {
        this.affiliations = affiliations;
    }

    public ArrayList<TherapistScopes> getScopes() {
        return scopes;
    }

    public void setScopes(ArrayList<TherapistScopes> scopes) {
        this.scopes = scopes;
    }

    public ArrayList<TherapistServices> getServices() {
        return services;
    }

    public void setServices(ArrayList<TherapistServices> services) {
        this.services = services;
    }

    public ArrayList<TherapistReview> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<TherapistReview> reviews) {
        this.reviews = reviews;
    }
}


