package com.mazhiwei.web.servlet; /**
 * @author 马治伟
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("get...");
//        String username = request.getParameter("username");
//        System.out.println(username);
//        response.getWriter().write("hello axios");
        //接受用户名
        String username = request.getParameter("username");
        boolean flag = true;

        response.getWriter().write("" + flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        this.doGet(request, response);
    }
}