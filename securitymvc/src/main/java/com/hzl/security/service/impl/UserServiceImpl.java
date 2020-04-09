package com.hzl.security.service.impl;

import com.hzl.security.pojo.User;
import com.hzl.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/9 8:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) {
        if (username == null || password == null) {
            throw new RuntimeException("用户名或者密码为空");
        }
        User user = queryUser(username);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        return user;
    }

    private User queryUser(String username) {
        User user = userMap.get(username);
        return user;
    }

    private HashMap<String, User> userMap = new HashMap<>();

    {
        Set<String> authoriters = new HashSet<>();
        authoriters.add("p1");
        Set<String> authoriters2 = new HashSet<>();
        authoriters2.add("p2");
        userMap.put("zhangsan", User.builder().username("zhangsan").mobile("15779989400").password("123456").author(authoriters).build());
        userMap.put("lisi", User.builder().username("lisi").mobile("13125239811").password("666666").author(authoriters2).build());
    }
}
