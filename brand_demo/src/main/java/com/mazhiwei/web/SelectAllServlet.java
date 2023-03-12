package com.mazhiwei.web; /**
 * @author 马治伟
 * @version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.mazhiwei.pojo.Brand;
import com.mazhiwei.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();

        String jsonString = JSON.toJSONString(brands);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
