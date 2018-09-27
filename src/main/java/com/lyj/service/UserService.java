package com.lyj.service;

import com.lyj.dao.UserDao;
import com.lyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Yingjie.Lu on 2018/9/17.
 */

@Transactional //加上事务
@Service
public class UserService {


    @Autowired
    UserDao userDao;


    public void saveUser(User user){
        userDao.save(user);
    }

    public User login(User user){
        if(user.getUserName()!=null && user.getPassword()!=null){
            Optional<User> one = userDao.findOne(Example.of(new User(user.getUserName())));
            if(one.isPresent()){
                if(one.get().getPassword().equals(user.getPassword())){
                    return one.get();
                }
            }
        }

        return null;
    }


}
