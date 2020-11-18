package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @ClassName : UserService
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 08:56
 */
public interface UserService {
    /*
    * 注册用户
    * */
    public void registUser(User user);

    /*
    * 登录
    * 返回null，则登陆失败
    * */
    public User login(User user);

    /**
     * @Description : * 用户名是否可用,返回true表示用户名已存在
     * @param username
     * @return boolean
     * @date 2020/11/11 11:48
     * @author formh
     */

    public boolean existUsername(String username);
}
