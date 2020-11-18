package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @ClassName : BookDaoImpl
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 21:18
 */


public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id = ? ";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryforList(Book.class, sql);

    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryforSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "SELECT `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";

        return queryforList(Book.class, sql, begin, pageSize);
    }
}
