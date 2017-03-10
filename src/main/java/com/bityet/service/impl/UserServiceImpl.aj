package com.bityet.service.impl;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import com.bityet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sean on 2017/3/10.
 */
@Service
public aspect UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User getUser(String username) {
        return this.userMapper.getUser(username);
    }
}
