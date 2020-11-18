package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @ClassName : UserServiceImpl
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 09:00
 */


public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            //等于null说明没查到,没查到表示可用
            return false;
        }
        return true;
    }
}
