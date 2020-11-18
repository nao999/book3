package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @ClassName : UserDaoImpl
 * @Description :
 * @Author : y
 * @Date: 2020-11-11 08:39
 */


public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);

    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`id`,`username`,`password`,`email`)values(?,?,?,?)";
        return update(sql, user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
    }
}
