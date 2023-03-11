package com.mazhiwei.web; /**
 * @author 马治伟
 * @version 1.0
 */

import com.mazhiwei.pojo.Brand;
import com.mazhiwei.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Brand brand = service.selectByIdBrand(Integer.parseInt(id));
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/delete.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
