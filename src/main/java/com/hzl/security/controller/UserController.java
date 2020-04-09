package com.hzl.security.controller;

import com.hzl.security.pojo.User;
import com.hzl.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/9 8:54
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",produces = "text/plain;charset=UTF-8")
    public String login(String username,String password,HttpSession session){
        User user = userService.login(username, password);
        if (StringUtils.isEmpty(user)){
            return "登录失败";
        }
        session.setAttribute(User.SESSION_USER_KEY,user);
        return "登录成功" + user;
    }

    @RequestMapping(value = "/logout",produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "退出成功";
    }

    @RequestMapping(value = "/r/r1",produces = "text/plain;charset=UTF-8")
    public String vist(HttpSession httpSession){
        Object attribute = httpSession.getAttribute(User.SESSION_USER_KEY);
        User user = (User) attribute;
        if (attribute == null){
            return "匿名访问";
        }else {
            return user.getUsername()+"访问资源成功";
        }
    }
    @RequestMapping(value = "/r/r2",produces = "text/plain;charset=UTF-8")
    public String shore(HttpSession httpSession){
        Object attribute = httpSession.getAttribute(User.SESSION_USER_KEY);
        User user = (User) attribute;
        if (attribute == null){
            return "匿名访问";
        }else {
            return user.getUsername()+"访问资源成功";
        }
    }
}
