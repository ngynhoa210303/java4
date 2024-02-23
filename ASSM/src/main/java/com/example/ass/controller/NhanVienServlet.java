package com.example.ass.controller;

import com.example.ass.entity.ChucVu;
import com.example.ass.entity.CuaHang;
import com.example.ass.entity.NhanVien;
import com.example.ass.service.ChucVuService;
import com.example.ass.service.CuaHangService;
import com.example.ass.service.NhanVienService;
import com.example.ass.service.impl.ChucVuServiceImpl;
import com.example.ass.service.impl.CuaHangServiceImpl;
import com.example.ass.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi-tat-ca",
        "/nhan-vien/remove",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/view-update",
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> lists = new ArrayList<>();
    private List<ChucVu> listCV = new ArrayList<>();
    private List<CuaHang> listCH = new ArrayList<>();
    private NhanVienService nvService = new NhanVienServiceImpl();
    private ChucVuService cvService = new ChucVuServiceImpl();
    private CuaHangService chService = new CuaHangServiceImpl();
    private UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThi(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nvService.getOne(id);
        request.setAttribute("detail",nv);
        CuaHang ch=nv.getIdCH();
        ChucVu cv=nv.getIdCV();
        this.setAd(request);
        request.setAttribute("cuaHang",ch);
        request.setAttribute("chucVu",cv);
        request.getRequestDispatcher("/view/nhanvien/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nvService.getOne(id);
        request.setAttribute("detail",nv);
        this.hienThi(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = nvService.getOne(id);
        nvService.deleteNV(nv);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setAd(request);
        request.getRequestDispatcher("/view/nhanvien/nhanviens.jsp").forward(request, response);
    }

    private void setAd(HttpServletRequest request) {
        lists = nvService.getAll();
        request.setAttribute("lists", lists);
        listCH = chService.getAll();
        request.setAttribute("listCH", listCH);
        listCV = cvService.getAll();
        request.setAttribute("listCV", listCV);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv=nvService.getData(request.getParameterMap());
        HashMap<String,String>hashMap=nvService.addNV(nv);
        request.setAttribute("detail",nv);
        request.setAttribute("sts",hashMap);
        this.setAd(request);
        request.setAttribute("mess", hashMap.get("mess"));
        request.getRequestDispatcher(hashMap.get("url")).forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv=nvService.getData(request.getParameterMap());
        nv.setId(id);
        HashMap<String,String>hashMap=nvService.updateNV(nv);
        request.setAttribute("detail",nv);
        request.setAttribute("sts",hashMap);
        this.setAd(request);
        request.setAttribute("mess", hashMap.get("mess"));
        request.getRequestDispatcher(hashMap.get("url")).forward(request, response);

    }
}
