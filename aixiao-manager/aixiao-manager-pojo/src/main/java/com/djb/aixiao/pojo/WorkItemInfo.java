package com.djb.aixiao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djb
 * @create 2019-05-30 13:17
 */
public class WorkItemInfo extends TbWork implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;

    private Long sno;

    private String workFileName;

    private String workFilePath;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commitTime;//提交作业时间

    private Integer minStatus;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getWorkFileName() {
        return workFileName;
    }

    public void setWorkFileName(String workFileName) {
        this.workFileName = workFileName;
    }

    public String getWorkFilePath() {
        return workFilePath;
    }

    public void setWorkFilePath(String workFilePath) {
        this.workFilePath = workFilePath;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public String getCommitT() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日  HH:mm:ss");
        String time = sdf.format(commitTime);
        return time;
    }


    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(Integer minStatus) {
        this.minStatus = minStatus;
    }
}
