package com.bityet.action;

import com.bityet.bean.User;
import com.bityet.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String toLogin(Model model,@ModelAttribute UsernamePasswordToken token){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(Model model, @ModelAttribute UsernamePasswordToken token, BindingResult errors){
        try {
            SecurityUtils.getSubject().login(token);
            String jwt= JWTUtil.generateJWT();
        }catch (AuthenticationException ae){

        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }
}
