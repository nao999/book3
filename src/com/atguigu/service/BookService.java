package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @ClassName : BookService
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 22:36
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
