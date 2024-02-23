package com.example.btvn9.controller;

import com.example.btvn9.entity.TaiKhoan;
import com.example.btvn9.service.UserService;
import com.example.btvn9.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserService uSer = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/btvn9/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("mess", "Tài khoản hoặc mật khẩu trống.");
            request.getRequestDispatcher("/btvn9/login.jsp").forward(request, response);
            return;
        }

        TaiKhoan user = uSer.checkTonTai(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            request.setAttribute("mess", "Tài khoản hoặc mật khẩu sai.");
            request.getRequestDispatcher("/btvn9/login.jsp").forward(request, response);
        }}
}
