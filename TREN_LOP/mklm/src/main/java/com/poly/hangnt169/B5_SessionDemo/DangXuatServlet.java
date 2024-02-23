package com.poly.hangnt169.B5_SessionDemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangXuatServlet", value = "/dang-xuat")
public class DangXuatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Xóa session
        HttpSession session= request.getSession();
        //2 cách xóa
//        C1: Xóa tất cả
        session.invalidate();
        //C2: Xóa ss nào đó
        session.removeAttribute("name");
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
