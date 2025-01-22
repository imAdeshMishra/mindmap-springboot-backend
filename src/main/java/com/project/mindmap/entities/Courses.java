package com.project.mindmap.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Courses {

    @Id
    private String courseId;

    // Generate the ID before persisting the entity
    @PrePersist
    public void generateId() {
        if (this.courseId == null) {
            this.courseId = UUID.randomUUID().toString();
        }
    }


    private String coarseTitle;

    private String coarseMotive;

    private String coarseInfo;

    private String coarseImg;

    public Courses() {
    }

    public Courses(String courseId, String coarseTitle, String coarseMotive, String coarseInfo,String coarseImg) {
        this.courseId = courseId;
        this.coarseTitle = coarseTitle;
        this.coarseMotive = coarseMotive;
        this.coarseInfo = coarseInfo;
        this.coarseImg = coarseImg;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCoarseTitle() {
        return coarseTitle;
    }

    public void setCoarseTitle(String coarseTitle) {
        this.coarseTitle = coarseTitle;
    }

    public String getCoarseMotive() {
        return coarseMotive;
    }

    public void setCoarseMotive(String coarseMotive) {
        this.coarseMotive = coarseMotive;
    }

    public String getCoarseInfo() {
        return coarseInfo;
    }

    public void setCoarseInfo(String coarseInfo) {
        this.coarseInfo = coarseInfo;
    }

    public String getCoarseImg() {
        return coarseImg;
    }

    public void setCoarseImg(String coarseImg) {
        this.coarseImg = coarseImg;
    }
}
