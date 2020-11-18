package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName : BaseDao
 * @Description :
 * @Author : y
 * @Date: 2020-11-10 16:02
 */


public abstract class BaseDao {
    //使用dbcUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    /**
     * @Description : update()方法用来执行insert、update、delete语句
     * @param []
     * @return int 如果返回-1说明执行失败
     * @date 2020/11/10 16:09
     * @author formh
     */
    public int update(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * @Description : 查询一个返回javaBean的sql语句
     * @param
     * @return
     * @date 2020/11/10 17:24
     * @author formh
     */

    public<T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * @Description : 查询返回多个javaBeanyu的sql语句
     * @param [type, sql, args]
     * @return java.util.List<T>
     * @date 2020/11/10 17:29
     * @author formh
     */
    public <T> List<T> queryforList(Class<T> type,String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * @Description : 执行返回一行一列的sql语句
     * @param [sql, args]
     * @return java.lang.Object
     * @date 2020/11/10 17:35
     * @author formh
     */
    public Object queryforSingleValue(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql ,new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
