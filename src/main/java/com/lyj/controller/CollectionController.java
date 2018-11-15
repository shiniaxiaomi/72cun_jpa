package com.lyj.controller;

import com.lyj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 陆英杰
 * 2018/11/13 15:51
 */

/**
 * 点击链接,直接进行收藏
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    //javascript:(function(x){window.open('http://www.usetools.cn/collection/url?url=[url]'.replace('[url]', encodeURIComponent(location.href)));})(document);



    @RequestMapping("/url")
    public ModelAndView colleciton(HttpSession session, HttpServletResponse response,
                                   @RequestParam(value = "url",required = false) String url,
                                   @RequestParam(value = "title",required = false) String title){

        if(url!=null && !"".equals(url) && title!=null && !"".equals(title)){//首次访问的时候就直接保存url和title
            try {
                session.setAttribute("url", URLDecoder.decode(url,"utf-8"));
                session.setAttribute("title",URLDecoder.decode(title,"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        ModelAndView mv=new ModelAndView();

        User user = (User) session.getAttribute("user");
        //如果用户没有登入,返回登入页面
        if(user==null){
            mv.setViewName("login");
        }else{
            mv.setViewName("collection");
            Object sessionUrl= session.getAttribute("url");
            Object sessionTitle= session.getAttribute("title");
            if(sessionUrl!=null && sessionTitle!=null){
                mv.addObject("url",sessionUrl);
                mv.addObject("title",sessionTitle);
            }
        }

        return mv;

    }


}
