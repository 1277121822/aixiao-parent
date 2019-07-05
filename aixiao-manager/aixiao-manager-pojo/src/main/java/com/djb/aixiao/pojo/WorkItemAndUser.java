package com.djb.aixiao.pojo;

/**
 * @author djb
 * @create 2019-06-02 1:07
 */
public class WorkItemAndUser extends TbWorkItem{

    private Long sno;

    private String username;

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
