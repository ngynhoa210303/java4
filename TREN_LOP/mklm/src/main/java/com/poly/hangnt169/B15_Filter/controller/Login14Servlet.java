package com.poly.hangnt169.B15_Filter.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login14Servlet", value = "/Login14Servlet")
public class Login14Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/buoi15/form-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// lấy dữ liệu từ form
        //check đăng nhập thanh cong-> ketqua.jsp
        //thất bại-> login
        String username = request.getParameter("uname");
        String pass = request.getParameter("psw");
        if (username.isEmpty() || pass.isEmpty()) {
            request.setAttribute("mess", "Tài khoản or mật khẩu trống");
            request.getRequestDispatcher("/buoi15/form-login.jsp").forward(request, response);
        }
        //Vld
        if (username.equalsIgnoreCase("PhongTT35") && pass.equals("123456")) {
            //Cách tạo 1 sesion tu request
            HttpSession session = request.getSession();
            //Tạo ra 1 biến ss
            session.setAttribute("name", username);
            //Chuyển sang trang home
            response.sendRedirect("/Login14Servlet");
        } else {
            request.setAttribute("mess", "Tài khoản or mật khẩu sai");
            request.getRequestDispatcher("/buoi15/ket-qua.jsp").forward(request, response);
        }
    }
}
