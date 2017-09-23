package com.bityet.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
public class EncryptUtil {

    private static final Key key;
    private static final String KEY_STR = "jiji12dau";
    private static final char[] hexDigits = {'a', '^', 'h', '$', 'K', '9', '6', '+', '8', 'a', 'N', '%', 'o', '0', 'd', 'F'};

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //DES
    public static String getEncryptString(String str) {
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64en.encode(encryptStrBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //DES
    public static String getDecryptString(String str) {
        BASE64Decoder base64De = new BASE64Decoder();
        try {
            byte[] strBytes = base64De.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public static String digestString(String str, String algorithm) throws NoSuchAlgorithmException {
        byte[] btInput = str.getBytes();
        MessageDigest mdInst = MessageDigest.getInstance(algorithm);
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        int j = md.length;
        char[] hexstr = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            hexstr[k++] = hexDigits[byte0 >>> 4 & 0xf];
            hexstr[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(hexstr);
    }*/

    public static Map<String,Object> initKeyPair() throws Exception{
        KeyPairGenerator kgen= KeyPairGenerator.getInstance("RSA");
        kgen.initialize(1024);
        KeyPair keyPair= kgen.generateKeyPair();
        RSAPublicKey pkey=(RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey ikey=(RSAPrivateKey) keyPair.getPrivate();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("private",ikey);
        map.put("public",pkey);
        return map;
    }

    public static String decryptByPrivateKey(byte[] encrypted,PrivateKey key) throws Exception{
        Cipher cipher=Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,key);
        return new String(cipher.doFinal(encrypted));
    }

    public static void main(String [] args){
       /* try {
            Map<String,Object> map=initKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
