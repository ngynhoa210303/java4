package com.example.ass.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrangChuServlet", value = {
        "/trang-chu",
        "/quan-ly/san-pham",
        "/quan-ly/nhan-vien",
        "/quan-ly/nsx",
        "/quan-ly/mau-sac",
        "/quan-ly/khach-hang",
        "/quan-ly/dong-sp",
        "/quan-ly/cua-hang",
        "/quan-ly/chuc-vu",
        "/quan-ly/chi-tiet-sp",

})
public class TrangChuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("trang-chu")) {
            request.getRequestDispatcher("/view/trangchu/trang-chu.jsp").forward(request, response);
        } else if (uri.contains("san-pham")) {
            request.getRequestDispatcher("/view/sanpham/sanphams.jsp").forward(request, response);
        } else if (uri.contains("nhan-vien")) {
            request.getRequestDispatcher("/view/nhanvien/nhanviens.jsp").forward(request, response);
        } else if (uri.contains("nsx")) {
            request.getRequestDispatcher("/view/nsx/nsxs.jsp").forward(request, response);
        } else if (uri.contains("mau-sac")) {
            request.getRequestDispatcher("/view/mausac/mausacs.jsp").forward(request, response);
        } else if (uri.contains("khach-hang")) {
            request.getRequestDispatcher("/view/khachhang/khachhangs.jsp").forward(request, response);
        } else if (uri.contains("dong-sp")) {
            request.getRequestDispatcher("/view/dongsp/dongsps.jsp").forward(request, response);
        } else if (uri.contains("cua-hang")) {
            request.getRequestDispatcher("/view/cuahang/cuahangs.jsp").forward(request, response);
        } else if (uri.contains("chuc-vu")) {
            request.getRequestDispatcher("/view/chucvu/chucvus.jsp").forward(request, response);
        } else if (uri.contains("chi-tiet-sp")) {
            request.getRequestDispatcher("/view/chitietsp/chitietsps.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/view/trangchu/trang-chu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
