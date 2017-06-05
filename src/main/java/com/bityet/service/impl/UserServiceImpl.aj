package com.bityet.service.impl;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import com.bityet.service.UserService;
import com.bityet.util.PemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

/**
 * Created by Sean on 2017/3/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User getUser(String username) {
        return this.userMapper.getUser(username);
    }

    public PublicKey getPublicKey() throws Exception{
       return PemUtils.readPublicKeyFromFile("/resources/rsa-public.pem","RSA");
    }
}
