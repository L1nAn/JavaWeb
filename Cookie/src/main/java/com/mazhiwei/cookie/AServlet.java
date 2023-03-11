package com.mazhiwei.cookie; /**
 * @author 马治伟
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "username";
        String value = "张三";
        value = URLEncoder.encode(value,"utf-8");
        System.out.println("存储的数据" + value);
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(7 * 60 * 60 * 24);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
