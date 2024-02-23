package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.NhanVien;
import com.fpt.poly.pe.service.NhanVienService;
import com.fpt.poly.pe.service.impl.NhanVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> listNV = new ArrayList<>();
    private UUID id;
    private NhanVienService nvService = new NhanVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nvService.getOne(id);
        nvService.delete(nv);
        this.hienThi(request, response);
        request.setAttribute("mess", "Xóa thành công");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nvService.getOne(id);
        request.setAttribute("sv", nv);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNV = nvService.getAll();
        if (listNV.isEmpty()) {
            request.setAttribute("message", "Không có dữ liệu");
        }
        request.setAttribute("listNV", listNV);
        request.getRequestDispatcher("/fe/view/nhanviens.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        nv.setMa(nvService.genMaNV());
        nv = nvService.getData(request.getParameterMap());
        HashMap<String, String> hashMap = nvService.add(nv);
        request.setAttribute("sv", nv);
        request.setAttribute("sts", hashMap);
        request.setAttribute("mess", hashMap.get("mess"));
        this.hienThi(request, response);
    }

}
