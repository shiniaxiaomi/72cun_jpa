package com.lyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD

/**
 * Created by 陆英杰
 * 2018/9/30 16:38
 */

/**
 * 返回模板页面的控制器
 */
@Controller
public class PageController {

    /**
     * 返回页面的首页
     * @return
     */
    @RequestMapping("/urlManager/mainManager/mainManager")
    public String mainManager(){
        return "/urlManager/mainManager/mainManager";
    }

    /**
     * 返回添加页面
     */
    @RequestMapping("/urlManager/mainManager/addURL")
    public String addURLManager(){
        return "/urlManager/mainManager/addURL";
    }

    /**
     * 返回文件夹管理页面
     * @return
     */
    @RequestMapping("/urlManager/folderManager")
    public String folderManager(){
        return "/urlManager/folderManager";
=======
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
>>>>>>> e8ae9ab7f552a5b6bcb2cc8fd841b70e2dfa7722
    }

}
