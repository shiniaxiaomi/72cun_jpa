package com.lyj.controller;

import com.lyj.entity.Folder;
import com.lyj.entity.Result;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.service.URLService;
import com.lyj.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/25 11:39
 */

@RestController
@RequestMapping("/url")
public class URLController {

    @Autowired
    URLService urlService;

    //需要分页
    @RequestMapping("/query")
    public PageEntity<URL> findByFolder(Folder folder,Integer pageSize,Integer pageIndex, HttpSession session){
        User user = (User) session.getAttribute("user");

        PageRequest pageRequest = PageRequest.of(pageIndex-1, pageSize);
        Page<URL> urls = urlService.findByFolder(user.getId(),folder,pageRequest);
        PageEntity<URL> pageEntity=new PageEntity<>(urls);

        return pageEntity;
    }

    //需要分页
    @RequestMapping("/queryAllLike")
    public PageEntity<URL> queryAllLike(String urlName, Integer pageSize, Integer pageIndex, HttpSession session){
        User user = (User) session.getAttribute("user");

        PageRequest pageRequest = PageRequest.of(pageIndex-1, pageSize);
        Page<URL> urls = urlService.queryAll(user.getId(), urlName, pageRequest);
        PageEntity<URL> pageEntity=new PageEntity<>(urls);
        return pageEntity;
    }


    @RequestMapping("/update")
    public Result update(URL url,Integer pid, HttpSession session){
        User user = (User) session.getAttribute("user");
        return urlService.update(user.getId(),url,pid);

    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        return urlService.delete(id);
    }

    @RequestMapping("/save")
    public Result save(URL url,HttpSession session){
        User user = (User) session.getAttribute("user");

        url.setUser(user);
        url.setFolder(new Folder(url.getPid()));
        return urlService.save(url);
    }








}
