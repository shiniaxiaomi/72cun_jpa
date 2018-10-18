package com.lyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Yingjie.Lu on 2018/10/7.
 */

@Controller
public class PageController {


    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/111")
    public String aaa(){
        return "111";
    }

    @RequestMapping("/searchUrl")
    public String searchUrl(){
        return "searchUrl";
    }

    @RequestMapping("/urlManager")
    public String urlManager(){
        return "urlManager";
    }

}
