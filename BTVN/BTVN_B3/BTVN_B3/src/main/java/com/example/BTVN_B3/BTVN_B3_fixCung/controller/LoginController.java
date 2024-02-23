package com.example.BTVN_B3.BTVN_B3_fixCung.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("form-login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!username.equals("HangNT169")||!password.equals("123456")){
            request.setAttribute("error","Tên hoặc mật khẩu của bạn chưa chính xác");
            request.getRequestDispatcher("/form-login.jsp").forward(request,response);
        }else {
            response.sendRedirect("/giao-vien/hien-thi");
        }
    }
}
