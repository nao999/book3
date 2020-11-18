package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName : UserServiceImplTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 09:06
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj", "666666", "bbj@qq.com"));
        userService.registUser(new User(null, "abc", "666666", "bbj@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "bbj", "666666", null)));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("bbj")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}