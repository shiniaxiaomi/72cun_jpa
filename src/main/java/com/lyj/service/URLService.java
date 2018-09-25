package com.lyj.service;

import com.lyj.dao.URLDao;
import com.lyj.dao.URLDao;
import com.lyj.dao.UserDao;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<URL> findAll(User user){
        URL url=new URL();
        url.setUser(user);
        return urlDao.findAll(Example.of(url));

    }


}
