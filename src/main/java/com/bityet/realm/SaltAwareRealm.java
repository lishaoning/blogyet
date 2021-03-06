package com.bityet.realm;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import com.bityet.util.PemUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;

/**
 * Created by Administrator on 2017/3/8.
 */
public class SaltAwareRealm extends AuthorizingRealm {

    private static final Logger logger = LogManager.getLogger(SaltAwareRealm.class);

    @Autowired
    private UserMapper userMapper;

    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User user = this.userMapper.getUser(upToken.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        if(user.isLocked()){
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
