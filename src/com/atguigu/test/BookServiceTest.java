package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ClassName : BookServiceTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 22:55
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"计算机组成原理", "1126", new BigDecimal(99), 10000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"深入理解计算机系统", "Randal E.Bryant", new BigDecimal(99), 10000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
}