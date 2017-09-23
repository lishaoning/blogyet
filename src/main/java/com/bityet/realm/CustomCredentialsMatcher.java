package com.bityet.realm;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by Administrator on 2017/9/22.
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SaltedAuthenticationInfo saltedInfo = (SaltedAuthenticationInfo) info;
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String salt = new String(saltedInfo.getCredentialsSalt().getBytes());
        String password = DigestUtils.md5Hex(DigestUtils.sha512Hex(new String(upToken.getPassword()))+salt);
        return equals(info.getCredentials(),password);
    }
}
