package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName : UserDaoTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 08:50
 */
public class UserDaoTest {
    UserDao userdao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userdao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userdao.queryUserByUsernameAndPassword("admin", "admin")==null){
            System.out.println("登陆失败");
        }else{
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userdao.saveUser(new User(null, "admin", "123456", "123@qq.com")));
    }
}