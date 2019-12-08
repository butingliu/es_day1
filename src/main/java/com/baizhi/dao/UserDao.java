package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //查询一个
    User selectByNameAndWord(@Param("username") String username,
                             @Param("password") String password);

    //添加用户
    void addUser(User user);
}
