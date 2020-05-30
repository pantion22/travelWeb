package com.cps.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台管理拦截器
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
    //目标方法执行之前
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            //未登录，返回登录页面
            response.sendRedirect("/login");
            return false;
        }
        //已登录，放行请求
        return true;
    }

}
