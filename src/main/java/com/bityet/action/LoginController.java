package com.bityet.action;

import com.bityet.bean.LoginCommand;
import com.bityet.service.UserService;
import com.bityet.util.EncryptUtil;
import com.bityet.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(Model model, @ModelAttribute LoginCommand command) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpSession session,Model model, @ModelAttribute LoginCommand command, BindingResult errors) {
        try {
            String encryptedPasswd=command.getPassword();
            PrivateKey key= (PrivateKey) session.getAttribute("private");
            String password=EncryptUtil.decryptByPrivateKey(new BASE64Decoder().decodeBuffer(encryptedPasswd),key);
            UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), password, command.isRememberMe());
            SecurityUtils.getSubject().login(token);
            String jwt = JWTUtil.generateJWT();
        } catch (AuthenticationException ae) {

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return "login";
    }

    @RequestMapping("/getPublicKey")
    @ResponseBody
    public String getPublicKey(HttpSession session) {
        try {
            Map<String,Object> keypair= EncryptUtil.initKeyPair();
            RSAPublicKey key = (RSAPublicKey) keypair.get("public");
            session.setAttribute("private",keypair.get("private"));
            return new BASE64Encoder().encode(key.getModulus().toByteArray())+"|"+key.getPublicExponent().toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
