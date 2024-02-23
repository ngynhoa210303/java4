package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.service.KhachHangService;
import com.fpt.poly.pe.service.impl.KhachHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    private List<KhachHang> listKhachHang = new ArrayList<>();
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        KhachHang kh = khachHangService.getOne(id);
        khachHangService.delete(kh);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKhachHang = khachHangService.getAll();
        if (listKhachHang.isEmpty()) {
            request.setAttribute("message", "List không ptu nào");
        }
        request.setAttribute("lists", listKhachHang);
        request.getRequestDispatcher("/fe/view/khachhangs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang kh = khachHangService.getData(request.getParameterMap());
        HashMap<String, String> hashMap = khachHangService.add(kh);
        request.setAttribute("sv", kh);
        request.setAttribute("mess", hashMap.get("mess"));
        request.setAttribute("sts", hashMap);
        this.hienThi(request, response);
    }
    }
