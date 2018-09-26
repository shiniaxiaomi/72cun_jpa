package com.lyj.controller;

import com.lyj.entity.Result;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.service.URLService;
import com.lyj.service.UserService;
import com.lyj.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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


    /**
     * mv.setViewName("redirect:main");//表示将url重定向到index,即让浏览器重新发起一次/main请求
     */
    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session){

        ModelAndView mv=new ModelAndView();

        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser!=null){//说明用户已经存在
            mv.setViewName("redirect:main");
            mv.addObject("user",user);
            return mv;
        }else{
            User loginedUser = userService.login(user);
            if(loginedUser!=null){

                mv.setViewName("redirect:main");
                session.setAttribute("user",loginedUser);
                mv.addObject("user",user);
                return mv;
            }else{
                mv.setViewName("forward:index");
                mv.addObject("msg","用户名或密码错误!");
                return mv;
            }

        }

    }
}
