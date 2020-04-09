package com.hzl.security.filter;

import com.hzl.security.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/9 10:16
 */
@Component
public class LoginFile implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object attribute = request.getSession().getAttribute(User.SESSION_USER_KEY);
        if (attribute == null){
            writContent(response,"请登录");
        }
        User user = (User) attribute;
       //拦截获取访问的url
        String requestURI = request.getRequestURI();
        if (user.getAuthor().contains("p1") && requestURI.contains("/r/r1")){
            return true;
        }
        if (user.getAuthor().contains("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        writContent(response,"没有权限拒绝访问");
        return false;
    }

    private void writContent(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
    }
}
