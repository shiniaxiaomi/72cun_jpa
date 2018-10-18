package com.lyj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by 陆英杰
 * 2018/9/25 11:36
 */
@Entity
public class URL {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    private String url;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Folder folder;

    //不生成数据库字段
    @Transient
    private Integer pid;

    //不生成数据库字段
    @Transient
    private String location;


    public URL() {
    }

    public URL(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public URL(Integer id,String name, String url, Folder folder) {
        this.id=id;
        this.name = name;
        this.url = url;
        this.folder = folder;
    }

    public URL(Integer id,String name, String url, Integer pid, String location) {
        this.id=id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
