package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @ClassName : UserDao
 * @Description :
 * @Author : y
 * @Date: 2020-11-10 17:37
 */


public interface UserDao {
    /*
     * @Description : 根据用户名查询用户信息
     * @param [username]
     * @return 返回null表明没有用户
     * @date 2020/11/11 8:35
     * @author formh
     */
    public User queryUserByUsername(String username);

    /*
     * @Description : 根据用户名和密码查询用户信息
     * @param 返回null表明没有用户,说明用户名或密码错误
     * @return com.atguigu.pojo.User
     * @date 2020/11/11 8:38
     * @author formh
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /*
     * @Description : 保存用户信息
     * @param user
     * @return 返回-1表示保存失败
     * @date 2020/11/11 8:36
     * @author formh
     */
    public int saveUser(User user);
}
