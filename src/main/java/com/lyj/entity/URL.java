package com.lyj.entity;

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

    @Column(length = 30)
    private String urlName;

    private String url;

    @ManyToOne
    private User user;

    public URL() {
    }

    public URL(String urlName, String url) {
        this.urlName = urlName;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
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
}
