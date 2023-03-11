package com.mazhiwei.servlet.response; /**
 * @author 马治伟
 * @version 1.0
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/demo05")
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/图片/wallhaven-kx8yzm.jpg");
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(fileInputStream,outputStream);
        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
