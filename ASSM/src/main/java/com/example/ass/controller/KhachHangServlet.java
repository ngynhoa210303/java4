package com.example.ass.controller;

import com.example.ass.entity.KhachHang;
import com.example.ass.service.KhachHangService;
import com.example.ass.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi-tat-ca",
        "/khach-hang/remove",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/view-update",
})
public class KhachHangServlet extends HttpServlet {
    private List<KhachHang> lists = new ArrayList<>();
    private UUID id;
    private String ma;
    private KhachHangService khSer = new KhachHangServiceImpl();

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
        KhachHang kh = khSer.getOne(id);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/view/khachhang/view-update.jsp").forward(request, response);

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        KhachHang kh = khSer.getOne(id);
        request.setAttribute("kh", kh);
        this.hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        KhachHang kh = khSer.getOne(id);
        khSer.delKH(kh);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = khSer.getAll();
        request.setAttribute("listKH", lists);
        request.getRequestDispatcher("/view/khachhang/khachhangs.jsp").forward(request, response);
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
        KhachHang kh = khSer.getData(request.getParameterMap(), true, ma);
//        kh.setMa(khSer.genMaKH());
        HashMap<String, String> hashMap = khSer.addKH(kh);
        request.setAttribute("kh", kh);
        if (hashMap.get("mess").equalsIgnoreCase("Add thành công")) {
            request.setAttribute("mess", hashMap.get("mess"));
            this.hienThi(request, response);
        } else {
            request.setAttribute("sts", hashMap);
            request.setAttribute("mess", hashMap.get("mess"));
            this.hienThi(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang kh = khSer.getData(request.getParameterMap(), false, ma);
        kh.setId(id);
        HashMap<String, String> hashMap = khSer.updateKH(kh);
        request.setAttribute("sts", hashMap);
        lists = khSer.getAll();
        request.setAttribute("kh", kh);
        request.setAttribute("listKH", lists);
        request.setAttribute("mess", hashMap.get("mess"));
        request.getRequestDispatcher(hashMap.get("url")).forward(request, response);
    }
}
