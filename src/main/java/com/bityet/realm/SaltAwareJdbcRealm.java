package com.bityet.realm;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/8.
 */
public class SaltAwareJdbcRealm extends JdbcRealm {

    private static final Logger logger = LogManager.getLogger(SaltAwareJdbcRealm.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User user = this.userMapper.getUser(upToken.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        String password=DigestUtils.sha256Hex(new String(upToken.getPassword()));
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"");
    }
}
