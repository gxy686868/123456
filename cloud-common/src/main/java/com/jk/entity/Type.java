package com.jk.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Type {
    private Integer pyqid;
    private String  username;
    private String content;
    private String imagePath;
    private Integer dzsl;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdatetime;

    //业务字段
    private Integer page;
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPyqid() {
        return pyqid;
    }

    public void setPyqid(Integer pyqid) {
        this.pyqid = pyqid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getDzsl() {
        return dzsl;
    }

    public void setDzsl(Integer dzsl) {
        this.dzsl = dzsl;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    @Override
    public String toString() {
        return "Type{" +
                "pyqid=" + pyqid +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", dzsl=" + dzsl +
                ", createdatetime=" + createdatetime +
                '}';
    }
}
