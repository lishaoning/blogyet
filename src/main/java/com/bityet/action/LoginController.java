package com.bityet.action;

import com.bityet.bean.User;
import com.bityet.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = {RequestMethod.GET})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String,Object> doLogin(UsernamePasswordToken token){
        try {
            SecurityUtils.getSubject().login(token);
            String jwt= JWTUtil.generateJWT();
        }catch (AuthenticationException ae){

        }
        return null;
    }
}
