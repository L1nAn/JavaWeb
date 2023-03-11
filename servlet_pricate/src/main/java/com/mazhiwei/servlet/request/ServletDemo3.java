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
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        if(method.equals("post")) {
            BufferedReader reader = req.getReader();
            String s = reader.readLine();
            System.out.println(s);
        }else {
            String queryString = req.getQueryString();
            System.out.println(queryString);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
}
