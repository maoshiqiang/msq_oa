package com.imooc.oa.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    //过滤器
public class EncodingFilter implements Filter {
    private String encoding ="utf-8";//定义指定默认，encoding是初始化参数的名字
    @Override
    //初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("encoding")!=null){
            encoding=filterConfig.getInitParameter("encoding");
        }
    }

    @Override
    //过滤拦截
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest; //强制转换成HTTP
        HttpServletResponse response=(HttpServletResponse)servletResponse; //强制转换成HTTP
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);//调用filterChain（拦截器链）

    }

    @Override
    public void destroy() {

    }
}
