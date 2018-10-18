package com.lyj.service;

import com.lyj.dao.URLDao;
import com.lyj.dao.URLDao;
import com.lyj.dao.UserDao;
import com.lyj.entity.Folder;
import com.lyj.entity.Result;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.util.ResultUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yingjie.Lu on 2018/9/17.
 */

@Transactional //加上事务
@Service
public class URLService {


    @Autowired
    URLDao urlDao;


    public void saveURL(URL url){
        urlDao.save(url);
    }

    public List<URL> findAll(){

//        URL url=new URL();
//        url.setUser(user);
//        return urlDao.findAll(Example.of(url));
        return null;

    }

    public Page<URL> findByFolder(Integer userId, Folder folder, PageRequest pageRequest){

        return urlDao.findByFolder(userId,folder.getId(),pageRequest);

    }


    @Transactional
    public Result update(Integer userId, URL url, Integer pid) {

        urlDao.update(url.getName(),url.getUrl(),pid,url.getId(),userId);
        return ResultUtil.success("更新成功!");
    }

    public Result delete(Integer id) {
        urlDao.deleteById(id);
        return ResultUtil.success("删除成功!");
    }

    public Page<URL> queryAll(Integer userId, String urlName, PageRequest pageRequest) {
        return urlDao.findAllByUser_IdAndNameLike(userId,"%"+urlName+"%",pageRequest);
    }

    public Result save(URL url){
        URL save = urlDao.save(url);
        if(save!=null){
            return ResultUtil.success("保存成功!",save);
        }else {
            return ResultUtil.error("保存失败!",save);
        }
    }
}
