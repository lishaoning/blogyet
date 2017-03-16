package com.bityet.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by Sean on 2017/3/15.
 */
public final class JWTUtil {

    private static RSAPublicKey publicKey=null;
    private static RSAPrivateKey privateKey=null;

    private static Algorithm algorithm=Algorithm.RS

    public static String generateJWT(){
        return JWT.create().withIssuer("").sign(algorithm);
    }
}
