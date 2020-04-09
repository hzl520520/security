package com.hzl.security.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/9 8:44
 */
@Data
@AllArgsConstructor
@Builder
public class User {
    public static final String SESSION_USER_KEY = "huangziling";
    private Set<String> author;
    private String username;
    private String password;
    private String mobile;
    private String sex;
}
