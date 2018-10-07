package com.lyj.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 陆英杰
 * 2018/9/30 10:47
 */

/**
 * 文件夹实体类
 */
@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer pId;//文件夹的父Id

    //是否是叶子节点(1表示文件夹下还有文件夹;0表示文件夹下没有文件夹了)
    private Integer isLeaf;

    //是否有url(1表示文件夹下还有url;0表示文件夹下没有url)
    private Integer isHasURL;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "folder")
    private Set<URL> urls=new HashSet<>();

    public Folder() {
    }

    public Folder(Integer id) {
        this.id=id;
    }

    public Folder(Integer id,String name) {
        this.id=id;
        this.name=name;
    }

    public Folder(String name, Integer pId, Integer isLeaf, Integer isHasURL, User user) {
        this.name = name;
        this.pId = pId;
        this.isLeaf = isLeaf;
        this.isHasURL = isHasURL;
        this.user = user;
    }

    public Folder(Integer id, String name, Integer pId, Integer isLeaf, Integer isHasURL){
        this.id=id;
        this.name = name;
        this.pId = pId;
        this.isLeaf = isLeaf;
        this.isHasURL = isHasURL;
    }

    public Folder(Integer folderId, String folderName, Integer pId) {
        this.id=folderId;
        this.name = folderName;
        this.pId = pId;
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getIsHasURL() {
        return isHasURL;
    }

    public void setIsHasURL(Integer isHasURL) {
        this.isHasURL = isHasURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<URL> getUrls() {
        return urls;
    }

    public void setUrls(Set<URL> urls) {
        this.urls = urls;
    }
}
