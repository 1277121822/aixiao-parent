package com.djb.aixiao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbClasses implements Serializable {
    private Long id;

    private String classesName;

    private Integer classesNumber;

    private Short grade;

    private Long deptId;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    public Integer getClassesNumber() {
        return classesNumber;
    }

    public void setClassesNumber(Integer classesNumber) {
        this.classesNumber = classesNumber;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}