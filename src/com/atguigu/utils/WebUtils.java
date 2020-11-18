package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName : WebUtils
 * @Description :
 * @Author : y
 * @Date: 2020-11-15 15:23
 */


public class WebUtils {

    /**
     * @Description : 把Map中的值注入到对应的JavaBean属性中
     * @param
     * @return void
     * @date 2020/11/15 15:37
     * @author formh
     */
    public static<T>  T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前:" + bean);
            //把所有参数注入到user对象中
            BeanUtils.populate(bean, value);
            System.out.println("注入之后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * @Description : 将字符串转换称为int类型
     * @param [strInt, defaultValue]
     * @return int
     * @date 2020/11/16 9:30
     * @author formh
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
