package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.ChucVu;
import com.fpt.poly.pe.entity.NhanVien;
import com.fpt.poly.pe.service.ChucVuService;
import com.fpt.poly.pe.service.NhanVienService;
import com.fpt.poly.pe.service.impl.ChucVuServiceImpl;
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
        "/nhan-vien/update",
        "/nhan-vien/view-update",
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> lists = new ArrayList<>();
    private List<ChucVu> listCV = new ArrayList<>();
    private NhanVienService nvService = new NhanVienServiceImpl();
    private ChucVuService cvService = new ChucVuServiceImpl();

    private UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id=UUID.fromString(request.getParameter("id"));
        NhanVien nv=nvService.getOne(id);
        request.setAttribute("detail",nv);
        this.setLists(request);
        request.getRequestDispatcher("/fe/view/view-update.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id=UUID.fromString(request.getParameter("id"));
        NhanVien nv=nvService.getOne(id);
        nvService.delete(nv);
        this.hienThi(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id=UUID.fromString(request.getParameter("id"));
        NhanVien nv=nvService.getOne(id);
        request.setAttribute("detail",nv);
        this.hienThi(request,response);
    }

    private void setLists(HttpServletRequest request){
        lists = nvService.getAll();
        request.setAttribute("lists", lists);
        listCV = cvService.getAll();
        request.setAttribute("listCV", listCV);
    }
    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setLists(request);
        request.getRequestDispatcher("/fe/view/nhanviens.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv=nvService.getData(request.getParameterMap());
        nv.setId(id);
//        nv.setMa(nvService.getOne(id).getMa());
        request.setAttribute("detail",nv);
        HashMap<String,String>hashMap=nvService.update(nv);
        request.setAttribute("mess",hashMap.get("mess"));
        request.setAttribute("sts",hashMap);
        this.setLists(request);
        request.getRequestDispatcher("/fe/view/nhanviens.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv=nvService.getData(request.getParameterMap());
        request.setAttribute("detail",nv);
        HashMap<String,String>hashMap=nvService.add(nv);
        request.setAttribute("mess",hashMap.get("mess"));
        request.setAttribute("sts",hashMap);
        this.hienThi(request,response);
    }
}
