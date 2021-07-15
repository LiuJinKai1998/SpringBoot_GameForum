package com.kai.config;

//拦截器

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler) throws Exception {
//        System.out.println("拦截器");
//        //登录成功之后，应该有用户的sessoin
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if (loginUser == null) {
//            request.setAttribute("msg", "没有权限，请先登录");
//            request.getRequestDispatcher("/index.html").forward(request, response);
//
//        } else {
//
//        }
//
//    }
}
