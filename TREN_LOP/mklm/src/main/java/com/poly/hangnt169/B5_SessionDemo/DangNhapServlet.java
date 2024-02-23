package com.poly.hangnt169.B5_SessionDemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangNhapServlet", value = "/login")
public class DangNhapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dang-nhap.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uname");
        String pass = request.getParameter("psw");
        if (username.isEmpty() || pass.isEmpty()) {
            request.setAttribute("mess", "Tài khoản or mật khẩu trống");
            request.getRequestDispatcher("/dang-nhap.jsp").forward(request, response);
        }
//Vld
        if (username.equalsIgnoreCase("hoant") && pass.equals("123456")) {
            //Cách tạo 1 sesion tu request
            HttpSession session=request.getSession();
            //Tạo ra 1 biến ss
            session.setAttribute("name",username);
            //Chuyển sang trang home
            response.sendRedirect("/home");
        }
        else {
            request.setAttribute("mess", "Tài khoản or mật khẩu sai");
            request.getRequestDispatcher("/dang-nhap.jsp").forward(request, response);
        }
    }
}
