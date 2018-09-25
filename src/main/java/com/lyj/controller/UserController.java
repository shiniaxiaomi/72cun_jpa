package com.lyj.controller;

import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.service.URLService;
import com.lyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/17 0:41
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    URLService urlService;


    @ResponseBody
    @RequestMapping("/save")
    public ModelAndView save(User user){

        ModelAndView mv=new ModelAndView("index");
        mv.addObject("msg","注册成功!");
        userService.saveUser(user);

        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session){

        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser!=null){//说明用户已经存在
//            if()
        }else{
            User loginedUser = userService.login(user);
            if(loginedUser!=null){

                session.setAttribute("user",loginedUser);

                ModelAndView mv=new ModelAndView("main");
                List<URL> urls = urlService.findAll(loginedUser);
                mv.addObject("urlList",urls);


                mv.addObject("msg","登入成功!");

                return mv;
            }else{

                ModelAndView mv=new ModelAndView("index");
                mv.addObject("msg","用户名或密码错误!");

                return mv;
            }

        }

        return null;

    }
}
