package com.mazhiwei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 马治伟
 * @version 1.0
 */
@WebFilter("/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("2. doFilter 被执行了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("4. 放行后////");

    }

    @Override
    public void destroy() {

    }
}
