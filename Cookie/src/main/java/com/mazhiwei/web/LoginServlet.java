package com.mazhiwei.web; /**
 * @author 马治伟
 * @version 1.0
 */

import com.mazhiwei.pojo.User;
import com.mazhiwei.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

        User user = service.login(username, password);
        if (user != null) {
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                c_username.setMaxAge(60 * 60 * 24);
                c_password.setMaxAge(60 * 60 * 24);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", user);//为什么还要这一步？？？？
            String contextPath = request.getContextPath();
            response.sendRedirect((contextPath + "/selectAllServlet"));
        } else {
            request.setAttribute("login_msg", "用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
