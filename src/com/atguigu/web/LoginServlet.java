package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : LoginServlet
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 14:34
 */


public class LoginServlet extends HttpServlet  {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()登录
        User loginUser = userService.login(new User(null, username, password, null));
        //如果等于null,说明登陆失败
        if(loginUser == null){
            //把错误信息和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("username", username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else{
            //登录成功
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}
