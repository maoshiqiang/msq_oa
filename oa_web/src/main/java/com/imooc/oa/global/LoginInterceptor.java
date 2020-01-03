package com.imooc.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //过滤：登录界面、登陆操作等相关的登录路径，确保正常登录
        String url = httpServletRequest.getRequestURI();//登录界面、登陆操作等相关的登录路径：放行
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }
        //如果是其他路径，判断是否登录
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("employee")!=null){
            //登录过：放行
            return true;
        }
        httpServletResponse.sendRedirect("/to_login");
        //既不是登录操作，也未登录，则进行拦截，重新登录
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}