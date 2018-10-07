package com.lyj.dao;

import com.lyj.entity.URL;
import com.lyj.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 陆英杰
 * 2018/9/25 9:42
 */
public interface URLDao extends JpaRepository<URL,Integer>{

    //返回全部的URl对象中的内容,包括URl中的User对象
//    public List<URL> findByUrlNameLikeAndUser_Id(String urlName,Integer userId);


    /**
     * 如果要查询部分字段的话可以自己写query语句
     * 如果要添加URl中的user对象中的属性条件,可以使用join url.user user 来加入user表,不过这样会降低性能
     */
    //使用HQL查询部分字段,但是这样返回的结果字段都是用012来表示的
//    @Query("select url.id,url.url,url.urlName from URL url join url.user user where user.id=:userId and url.urlName like %:urlName%")
    //使用HQL查询部分字段,通过new POJO()实现,这样返回的结果中就会有对应的字段名,推荐使用
    @Query("select new URL(url.id,url.name,url.url,folder.id,folder.name,folder.pId) from URL url join url.user user join url.folder folder where user.id=:userId and url.name like %:name%")
    public Page<URL> findByUrlNameLikeAndUser_Id(@Param("name") String name, @Param("userId") Integer userId, Pageable pageable);

}
