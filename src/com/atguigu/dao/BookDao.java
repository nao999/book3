package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @ClassName : BookDao
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 21:15
 */


public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
