package com.dfbz.entity;

import java.io.Serializable;

public class TbResult implements Serializable {
    private Long resId;

    private String resSubject;

    private Float resScore;

    private Long stuId;

    // 一方属性
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getResSubject() {
        return resSubject;
    }

    public void setResSubject(String resSubject) {
        this.resSubject = resSubject == null ? null : resSubject.trim();
    }

    public Float getResScore() {
        return resScore;
    }

    public void setResScore(Float resScore) {
        this.resScore = resScore;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "TbResult{" +
                "resId=" + resId +
                ", resSubject='" + resSubject + '\'' +
                ", resScore=" + resScore +
                ", stuId=" + stuId +
                '}';
    }
}