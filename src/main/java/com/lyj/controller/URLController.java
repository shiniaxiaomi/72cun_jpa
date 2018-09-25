package com.lyj.controller;

import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;

/**
 * Created by 陆英杰
 * 2018/9/25 11:39
 */

@Controller
@RequestMapping("/url")
public class URLController {

    @Autowired
    URLService urlService;

    @RequestMapping("/save")
    public ModelAndView save(URL url, HttpSession session){
        ModelAndView mv=new ModelAndView("main");


        User user = (User) session.getAttribute("user");
        url.setUser(user);
        urlService.saveURL(url);//保存




        return mv;


    }




}
