package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    //查询一个
    User queryByNameAndWord(String username, String password);

    //添加用户
    void insertUser(User user);
}
