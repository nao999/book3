package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.sql.Connection;

/**
 * @ClassName : JdbcUtilsTest
 * @Description :
 * @Author : y
 * @Date: 2020-11-10 15:55
 */


public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        JdbcUtils.close(conn);
    }
}
