package com.example.BTVN_Buoi5.controller;


import com.example.BTVN_Buoi5.service.LoginService;
import com.example.BTVN_Buoi5.service.impl.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usrn = request.getParameter("usrn");
        String psw = request.getParameter("psw");
        if (loginService.checkLogin(usrn, psw)) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            request.setAttribute("status", "Vui long kiem tra TK va mat khau");
            response.sendRedirect("/login");
        }
    }
}
