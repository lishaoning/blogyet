package com.bityet.action;

import com.bityet.bean.LoginCommand;
import com.bityet.bean.User;
import com.bityet.service.UserService;
import com.bityet.util.JWTUtil;
import com.bityet.util.PemUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(Model model, @ModelAttribute LoginCommand command) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(Model model, @ModelAttribute LoginCommand command, BindingResult errors) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword(), command.isRememberMe());
            SecurityUtils.getSubject().login(token);
            String jwt = JWTUtil.generateJWT();
        } catch (AuthenticationException ae) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping("/getPublicKey")
    @ResponseBody
    public String getPublicKey() {
        try {
            RSAPublicKey key = (RSAPublicKey) PemUtils.readPublicKeyFromFile("E:/bityet/blogyet/src/main/resources/rsa-public.pem","RSA");
            return new BASE64Encoder().encode(key.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
