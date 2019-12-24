package com.dfbz.entity;

import java.io.Serializable;
import java.util.List;

/*
* 与mybatis库中的Student表对应
* */
public class Student implements Serializable {
    private Integer stuId;
    private  String stuName;
    private String stuPassword;
    private Integer stuAge;

    // 多方属性
    private List<TbResult> tbResults;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    public List<TbResult> getTbResults() {
        return tbResults;
    }

    public void setTbResults(List<TbResult> tbResults) {
        this.tbResults = tbResults;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }
}
