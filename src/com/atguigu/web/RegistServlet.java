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
 * @ClassName : RegistServlet
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 09:17
 */


public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    /*     *
     * 正确
     *
     *           可用
     *               调用Service程序保存到数据库中
     *
     *               跳回注册页面
     * 不正确
     *           跳回注册页面
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2 检查验证码是否正确  ---暂时先写死验证码:abcde
        if("abcde".equalsIgnoreCase(code)){
            //3 检查用户名是否可用
            if(userService.existUsername(username)){
                //不可用
                System.out.println("用户名[" + username + "]已存在");

                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else{
                //可用
                //调用Service程序保存到数据库中
                userService.registUser(new User(null, username, password, email));
                //   跳到注册成功页面regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        }else{
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);


            System.out.println("验证码" + code + "错误");
            //跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }



    }
}
