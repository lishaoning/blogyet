package com.bityet.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAKey;

import static com.bityet.util.PemUtils.*;

/**
 * Created by Sean on 2017/3/15.
 */
public final class JWTUtil {

    /*private static final String PRIVATE_KEY_FILE = "src/main/resources/rsa-private.pem";*/
    private static final String PUBLIC_KEY_FILE = "src/main/resources/rsa-public.pem";

    public static String generateJWT() throws Exception{
        return JWT.create().withIssuer("").sign(Algorithm.RSA256((RSAKey)readPublicKeyFromFile(PUBLIC_KEY_FILE, "RSA")));
    }
}
