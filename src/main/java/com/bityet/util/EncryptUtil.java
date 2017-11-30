package com.bityet.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
public class EncryptUtil {

    private static final String KEY_ALGORITHM ="AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final Key key;
    private static final String KEY_STR = "jiji12dau";

    static {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG","SUN");
            secureRandom.setSeed(KEY_STR.getBytes());
            kg.init(128, secureRandom);
            key = kg.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEncryptString(String data) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    public static String getDecryptString(String data) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

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

    public static String decryptByPublicKey(byte[] data,PublicKey key) throws Exception{
        Cipher cipher=Cipher.getInstance(key.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,key);
        return Base64.encodeBase64String(cipher.doFinal(data));
    }

    public static void main(String [] args){
        try {
            System.out.println(getEncryptString("oohbeard"));
            System.out.println(getEncryptString("fangfromhaishang"));
        }catch (Exception e){

        }
    }
}
