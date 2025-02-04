package com.project.mindmap.dto;

public class TherapistDTO {

    private String therapistId;
    private String name;
    private String dob;
    private String gender;
    private String maritalStatus;
    private String specialisation;
    private String subSpecialisation;

    public TherapistDTO(String therapistId, String name, String dob, String gender, String maritalStatus, String specialisation, String subSpecialisation) {
        this.therapistId = therapistId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.specialisation = specialisation;
        this.subSpecialisation = subSpecialisation;
    }

    public String getTherapistId() { return therapistId; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getMaritalStatus() { return maritalStatus; }
    public String getSpecialisation() { return specialisation; }
    public String getSubSpecialisation() { return subSpecialisation; }
}
