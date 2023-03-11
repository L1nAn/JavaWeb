package com.mazhiwei.servlet.request; /**
 * @author 马治伟
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String a = "";
        if (method.equals("post")) {
            request.setCharacterEncoding("utf-8");
            a = request.getParameter("username");
        } else {
//            byte[] usernames = request.getParameter("username").getBytes("ISO-8859-1");
//            a = new String(usernames,"utf-8");
            a = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        }

        System.out.println(a);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
