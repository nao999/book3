package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : ClientBookServlet
 * @Description :
 * @Author : y
 * @Date: 2020-11-18 08:56
 */


public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * @Description : 处理分页功能
     * @param
     * @return void
     * @date 2020/11/16 11:21
     * @author formh
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了前台的ClientBookService程序");
        //1 获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pagSize"), Page.PAGE_SIZE);
        //2 调用BookService。page(pageNo,pageSite):page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //3 保存Page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
