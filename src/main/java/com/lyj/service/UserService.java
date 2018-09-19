package com.lyj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yingjie.Lu on 2018/9/17.
 */

@Service
public class UserService {


    @Autowired
    JdbcTemplate jdbcTemplate;

    //标记这个一个声明式事务
    @Transactional
    public void insert(){
        String sql="INSERT INTO USER (username,PASSWORD) VALUE(?,?)";
        jdbcTemplate.update(sql,"admin",19);

        System.out.println("数据插入成功");
        int i=10/1;//会抛出异常,如果加上事务处理,则方法会回滚
    }

}
