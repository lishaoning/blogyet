package com.bityet.action;

import com.bityet.bean.LoginCommand;
import com.bityet.service.UserService;
import com.bityet.util.EncryptUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    public String toLogin(Model model, @ModelAttribute LoginCommand command) {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpSession session,Model model, @ModelAttribute LoginCommand command, BindingResult errors) {
        try {
            String encryptedPasswd=command.getPassword();
            PrivateKey key= (PrivateKey) session.getAttribute("private");
            String password=EncryptUtil.decryptByPrivateKey(Base64.decodeBase64(encryptedPasswd),key);
            UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), password, command.isRememberMe());
            SecurityUtils.getSubject().login(token);
//            String jwt = JWTUtil.generateJWT();
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            e.printStackTrace();
            errors.reject("error.login.generic","用户名或密码错误");
            return "login";
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:/index";
    }

    @GetMapping("/getPublicKey")
    @ResponseBody
    public String getPublicKey(HttpSession session) {
        try {
            Map<String,Object> keypair= EncryptUtil.initKeyPair();
            RSAPublicKey key = (RSAPublicKey) keypair.get("public");
            session.setAttribute("private",keypair.get("private"));
            return Base64.encodeBase64String(key.getModulus().toByteArray())+"|"+key.getPublicExponent().toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
