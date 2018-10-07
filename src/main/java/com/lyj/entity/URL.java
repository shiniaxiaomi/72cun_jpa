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
    private String name;

    private String url;

    @ManyToOne
    private User user;

    @ManyToOne
    private Folder folder;


    public URL(String name, String url, User user, Folder folder) {
        this.name = name;
        this.url = url;
        this.user = user;
        this.folder = folder;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public URL() {
    }

    public URL(Integer id,String name, String url) {
        this.id=id;
        this.name = name;
        this.url = url;
    }

    public URL(Integer id,String name, String url,Integer folderId,String folderName,Integer pId) {
        this.id=id;
        this.name = name;
        this.url = url;

        this.folder=new Folder(folderId,folderName,pId);

    }

    public URL(String name, String url) {
        this.name = name;
        this.url = url;
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
}
