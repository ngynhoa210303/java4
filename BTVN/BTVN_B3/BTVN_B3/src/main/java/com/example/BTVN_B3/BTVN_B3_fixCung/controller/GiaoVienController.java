package com.example.BTVN_B3.BTVN_B3_fixCung.controller;

import com.example.BTVN_B3.BTVN_B3_fixCung.entity.GiaoVien;
import com.example.BTVN_B3.BTVN_B3_fixCung.service.GiaoVienService;
import com.example.BTVN_B3.BTVN_B3_fixCung.service.impl.GiaoVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiaoVienController", value = {
        "/giao-vien/login",
        "/giao-vien/hien-thi"
})

public class GiaoVienController extends HttpServlet {
    private GiaoVienService giaoVienService = new GiaoVienServiceImpl();
    private List<GiaoVien> giaoViens = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiaoVien(request, response);
        }
        request.getRequestDispatcher("/form-login.jsp").forward(request, response);
    }

    private void hienThiGiaoVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giaoViens.add(new GiaoVien(1, "HangNT169", "Tao", 3, true, "Dong Bang"));
        giaoViens.add(new GiaoVien(2, "HangNT169", "Tao", 3, false, "Dong Bang"));
        giaoViens.add(new GiaoVien(3, "HangNT169", "Tao", 3, true, "Dong Bang"));
        request.setAttribute("listGiaoVien", giaoViens);
        request.getRequestDispatcher("/giaoViens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
         ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addSinhVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiGiaoVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }
}

