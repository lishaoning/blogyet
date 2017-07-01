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
            int key_len = privateKey.getModulus().bitLength() / 16;
            byte[] bytes = DatatypeConverter.parseBase64Binary(new String(upToken.getPassword()));
            byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
            System.err.println(bcd.length);
            //如果密文长度大于模长则要分组解密
            String ming = "";
            byte[][] arrays = splitArray(bcd, key_len);
            for(byte[] arr : arrays) {
                ming += new String(ci.doFinal(arr));
            }
            System.out.println(ming);
        }catch (IOException ie){
            ie.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleAuthenticationInfo("lisn","111qqq","");
    }

    public byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }

    public byte[][] splitArray(byte[] data,int len){
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if(y!=0){
            z = 1;
        }
        byte[][] arrays = new byte[x+z][];
        byte[] arr;
        for(int i=0; i<x+z; i++){
            arr = new byte[len];
            if(i==x+z-1 && y!=0){
                System.arraycopy(data, i*len, arr, 0, y);
            }else{
                System.arraycopy(data, i*len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }
}
