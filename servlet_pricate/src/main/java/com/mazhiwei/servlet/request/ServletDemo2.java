package com.mazhiwei.servlet.request;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 马治伟
 * @version 1.0
 */
@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String uri = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        String method = req.getMethod();//获取请求方式
        String queryString = req.getQueryString();//get获取请求参数

        String contextPath = req.getContextPath();//项目访问路径

        System.out.println(uri);
        System.out.println(requestURL);
        System.out.println(req);
        System.out.println(method);
        System.out.println(queryString);
        System.out.println(contextPath);

        //获取请求头数据
        String header = req.getHeader("user-agent");
        System.out.println(header);
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().write("<h1>" + name + "欢迎您！</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
    }
}
