package com.bityet.realm;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/8.
 */
public class SaltAwareJdbcRealm extends JdbcRealm{

    private static final Logger logger= LogManager.getLogger(SaltAwareJdbcRealm.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
        User user=this.userMapper.getUser(usernamePasswordToken.getUsername());
        return null;
    }
}
