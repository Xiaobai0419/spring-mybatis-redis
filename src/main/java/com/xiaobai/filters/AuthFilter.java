package com.xiaobai.filters;

import com.xiaobai.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@Slf4j
@WebFilter(filterName = "authFilter",urlPatterns = {"/*"})//拦截所有请求
public class AuthFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(req,resp);//如果什么都不写，所有请求失效！！
    }

    public void destroy() {

    }
}
