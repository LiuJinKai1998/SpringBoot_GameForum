package com.kai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //添加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/reg.html").setViewName("reg");
        registry.addViewController("/main.html").setViewName("dashboard");


        registry.addViewController("/game.html").setViewName("users/game");
        registry.addViewController("/gamelist.html").setViewName("users/gamelist");
        registry.addViewController("/usercontent.html").setViewName("users/usercontent");
        registry.addViewController("/userclock.html").setViewName("users/userclock");
        registry.addViewController("/usermessage.html").setViewName("users/usermessage");
        registry.addViewController("/usernews.html").setViewName("users/usernews");

        /*管理器视图*/
        registry.addViewController("/aglist.html").setViewName("admin/aglist");
        registry.addViewController("/ulist.html").setViewName("admin/ulist");
        registry.addViewController("/updategame.html").setViewName("admin/updategame");
        registry.addViewController("/upuser.html").setViewName("admin/upuser");


    }



//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login", "/css/**", "/js/**", "/img/**");
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册拦截器1，对商家管理系统进行权限验证
//        InterceptorRegistration registration1 = registry.addInterceptor(new userceptor());
//        //指定拦截器1要拦截的请求(支持*通配符)
//        registration1.addPathPatterns("/users/**");
//
//        //注册拦截器2，对超级管理员系统进行权限验证
//        InterceptorRegistration registration2 = registry.addInterceptor(new adminceptor());
//        /*指定拦截器2要拦截的请求(支持*通配符)*/
//        registration2.addPathPatterns("/");
//        //指定拦截器2不拦截的请求(支持*通配符)
//        registration2.excludePathPatterns("/");
//    }
}
