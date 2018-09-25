package com.lyj.config;

import com.lyj.config.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Yingjie.Lu on 2018/9/17.
 */


@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 添加自定义的拦截器(用户登入验证)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        //拦截的作用是判断是否已经登入(即判断session中是否已经有user对象)
        registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/user/login","/user/save");
    }

    /**
     * addViewControllers可以方便的实现一个请求直接映射成视图，而无需书写controller
     * registry.addViewController("请求路径").setViewName("请求页面文件路径")
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/222").setViewName("/bbb.html");
    }
}
