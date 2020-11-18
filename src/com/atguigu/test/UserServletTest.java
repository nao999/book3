package com.atguigu.test;

import com.atguigu.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @ClassName : UserServletTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 09:21
 */


public class UserServletTest {
    public void login(){
        System.out.println("这是login()方法调用了");
    }

    public void regist(){
        System.out.println("这是regist()方法调用了");
    }

    public void updateUser(){
        System.out.println("这是updateUser()方法调用了");
    }

    public void updateUserPassword(){
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            //获取action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
          //  System.out.println(method);

            method.invoke(new UserServletTest() );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
