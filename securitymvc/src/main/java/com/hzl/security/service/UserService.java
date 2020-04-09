package com.hzl.security.service;

import com.hzl.security.pojo.User;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/9 8:42
 */
public interface UserService  {

    User login(String userName, String passWord);
}
