package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName : BookDaoTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 22:29
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "计算机网络", "谢希仁", new BigDecimal(99), 10000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "计算机网络(第七版)", "谢希仁", new BigDecimal(99), 10000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookDao.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(8, 4)) {
            System.out.println(book);
        }
    }


}