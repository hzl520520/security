package com.hzl.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/8 15:51
 * excludeFilters 排除controller注解的扫描
 * 这个类相当于ApplicationConfig.xml
 */
@Configuration
@ComponentScan(basePackages = "com.hzl.security"
,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
}
