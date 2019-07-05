package com.djb.aixiao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbWorkItem implements Serializable {
    private String id;

    private Long studentId;

    private String workId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String workFileName;

    private String workFilePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getWorkFileName() {
        return workFileName;
    }

    public void setWorkFileName(String workFileName) {
        this.workFileName = workFileName == null ? null : workFileName.trim();
    }

    public String getWorkFilePath() {
        return workFilePath;
    }

    public void setWorkFilePath(String workFilePath) {
        this.workFilePath = workFilePath == null ? null : workFilePath.trim();
    }
}