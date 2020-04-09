package com.hzl.security.config;

import com.hzl.security.filter.LoginFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author hzl
 * @version 1.0
 * @date 2020/4/8 15:59
 * includeFilters 扫描controller类
 * 这个类相当于speingMvc.xml
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hzl.security",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginFile loginFile;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginFile).addPathPatterns("/r/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
    }


    //视图解析器
    @Bean
    public InternalResourceViewResolver view() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
