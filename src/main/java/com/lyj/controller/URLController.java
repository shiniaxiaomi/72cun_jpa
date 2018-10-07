package com.lyj.controller;

import com.lyj.entity.Folder;
import com.lyj.entity.Result;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.service.URLService;
import com.lyj.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/25 11:39
 */

@Controller
@RequestMapping("/url")
public class URLController {

    @Autowired
    URLService urlService;

    @ResponseBody
    @RequestMapping("/save")
    public Result save(URL url,Integer folderId, HttpSession session){

        //因为有userSession的拦截器,所以只要方法能够进来,就说明已经存在user
        User user = (User) session.getAttribute("user");

        url.setUser(user);
        url.setFolder(new Folder(folderId));

        boolean isSave = urlService.saveURL(url);//保存
        if(isSave){
            return ResultUtil.success("url保存成功!");
        }else {
            return ResultUtil.error("url保存失败!");
        }

    }

    @ResponseBody
    @RequestMapping("/update")
    public Result update(URL url){


        boolean isUpdate = urlService.updateURL(url);//保存
        if(isUpdate){
            return ResultUtil.success("url保存成功!");
        }else {
            return ResultUtil.error("url保存失败!");
        }

    }

    @ResponseBody
    @RequestMapping("/query")
    public List<URL> query(HttpSession session){

        User user = (User) session.getAttribute("user");

        List<URL> urls = urlService.findAll(user);

        return urls;
    }


    /**
     * 关键字查询
     * @param key 关键字
     */
    @ResponseBody
    @RequestMapping("/search")
    public List<URL> findByURLName(String key,Integer pageIndex,Integer pageSize,HttpSession session){

        User user = (User) session.getAttribute("user");

        List<URL> urls = urlService.findByURLName(key, user.getId(), pageIndex, pageSize);


        return urls;

    }


    @ResponseBody
    @RequestMapping("delete")
    public Result delete(Integer urlId){
        urlService.delete(urlId);
        return ResultUtil.success("删除成功!");
    }




}
