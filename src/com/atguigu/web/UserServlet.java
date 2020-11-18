package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import com.sun.source.util.DocSourcePositions;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName : UserServlet
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 09:03
 */


public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * @Description : 处理登录功能
     * @param
     * @return void
     * @date 2020/11/15 9:15
     * @author formh
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * @Description : 处理注册功能
     * @param
     * @return void
     * @date 2020/11/15 9:15
     * @author formh
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

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
