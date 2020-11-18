package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.sun.jdi.connect.Connector;

import java.util.List;

/**
 * @ClassName : BookServiceImpl
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 22:49
 */


public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();



        //设置每页显示的数量
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);



        //设置当前页码
        page.setPageNo(pageNo);


        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前数据
        page.setItems(items);
        return page;
    }
}
