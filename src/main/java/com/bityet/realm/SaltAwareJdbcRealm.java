package com.bityet.realm;

import com.bityet.bean.User;
import com.bityet.mapper.UserMapper;
import com.bityet.util.PemUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;

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
       /* User user = this.userMapper.getUser(upToken.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }*/
        RSAPrivateKey privateKey=null;
        try {
            privateKey = (RSAPrivateKey) PemUtils.readPrivateKeyFromFile("E:/bityet/blogyet/src/main/resources/rsa-private.pem","RSA");
            Cipher ci = Cipher.getInstance("RSA");
            ci.init(Cipher.DECRYPT_MODE,privateKey);
            byte [] bytes =ci.doFinal(DatatypeConverter.parseHexBinary(new String(upToken.getPassword())));
            System.out.println(new String(bytes));
            String password=DigestUtils.sha256Hex(new String(bytes));
            if (!password.equals("111qqq")) {
                throw new IncorrectCredentialsException();
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleAuthenticationInfo("lisn","111qqq","");
    }
}
