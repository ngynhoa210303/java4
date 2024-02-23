package com.example.ass.controller;

import com.example.ass.entity.SanPham;
import com.example.ass.service.SanPhamService;
import com.example.ass.service.impl.SanPhamServiceImpl;
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

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi-tat-ca",
        "/san-pham/remove",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/view-update",
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> lists = new ArrayList<>();
    private UUID id;
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

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
        SanPham sp = sanPhamService.getOne(id);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/view/sanpham/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        SanPham sp = sanPhamService.getOne(id);
        request.setAttribute("sp", sp);
        this.hienThi(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        SanPham sp = sanPhamService.getOne(id);
        request.setAttribute("sp", sp);
        sanPhamService.deleteSP(sp);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = sanPhamService.getAll();
        request.setAttribute("listSP", lists);
        request.getRequestDispatcher("/view/sanpham/sanphams.jsp").forward(request, response);
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
        SanPham sp = sanPhamService.getData(request.getParameterMap());
//        sp.setMa(sanPhamService.genMaKhachHang());
        HashMap<String, String> hmString = sanPhamService.addSP(sp);
        request.setAttribute("sp", sp);
        request.setAttribute("sts", hmString);
        lists = sanPhamService.getAll();
        request.setAttribute("listSP", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sp = sanPhamService.getData(request.getParameterMap());
        sp.setId(id);
        HashMap<String, String> hmString = sanPhamService.updateSP(sp);
        request.setAttribute("sts", hmString);
        lists = sanPhamService.getAll();
        request.setAttribute("listSP", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}
