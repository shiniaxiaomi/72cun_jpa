package com.lyj.service;

import com.lyj.dao.FolderDao;
import com.lyj.dao.URLDao;
import com.lyj.entity.Folder;
import com.lyj.entity.URL;
import com.lyj.entity.User;
import com.lyj.util.VarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    FolderDao folderDao;


    public boolean saveURL(URL url){
        URL save = urlDao.save(url);
        if (save!=null){

            //将该文件夹标记为有url
            Optional<Folder> folder = folderDao.findById(url.getFolder().getId());
            if(folder.get().getIsHasURL()==VarUtil.intTure){//如果已经标记为有url,则不再标记为有url
                folder.get().setIsHasURL(VarUtil.intTure);
                folderDao.save(folder.get());
            }

            return true;
        }
        return false;
    }

    public boolean updateURL(URL url){
        Optional<URL> url1 = urlDao.findById(url.getId());
        url1.get().setUrl(url.getUrl());
        url1.get().setName(url.getName());
        URL url2 = urlDao.saveAndFlush(url1.get());
        if(url2!=null){

            return true;
        }
        return false;
    }

    public List<URL> findAll(User user){
        URL url=new URL();
        url.setUser(user);
        return urlDao.findAll(Example.of(url));

    }


    public List<URL> findByURLName(String urlName, Integer userId, Integer pageIndex, Integer pageSize){
        if(urlName==null){
            return null;
        }

        Page<URL> urls = urlDao.findByUrlNameLikeAndUser_Id(urlName, userId, PageRequest.of(pageIndex, pageSize));

        List<URL> content = urls.getContent();
        return content;
    }

    public void delete(Integer urlId){
        urlDao.deleteById(urlId);
    }


}
