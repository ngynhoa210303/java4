package com.example.ass.controller;

import com.example.ass.entity.NhaSanXuat;
import com.example.ass.service.NhaSanXuatService;
import com.example.ass.service.impl.NhaSanXuatServiceImpl;
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

@WebServlet(name = "NSXServlet", value = {
        "/nha-san-xuat/hien-thi-tat-ca",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/add",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/update",
        "/nha-san-xuat/view-update",
})
public class NSXServlet extends HttpServlet {
    private List<NhaSanXuat> lists = new ArrayList<>();
    private NhaSanXuatService nsxSer = new NhaSanXuatServiceImpl();
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
        NhaSanXuat nsx = nsxSer.getOne(id);
        request.setAttribute("nsx", nsx);
        request.getRequestDispatcher("/view/nsx/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhaSanXuat nsx = nsxSer.getOne(id);
        request.setAttribute("nsx", nsx);
        this.hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        NhaSanXuat nsx = nsxSer.getOne(id);
        nsxSer.delete(nsx);
        lists = nsxSer.getAll();
        request.setAttribute("mess", "Xóa thành công");

        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = nsxSer.getAll();
        if (lists.isEmpty()) {
            request.setAttribute("message", "Không có bản ghi nào");
        } else {
            request.setAttribute("listNSX", lists);
        }
        request.getRequestDispatcher("/view/nsx/nsxs.jsp").forward(request, response);

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
        NhaSanXuat nsx = nsxSer.getData(request.getParameterMap());
        HashMap<String, String> hmString = nsxSer.add(nsx);
        request.setAttribute("nsx", nsx);
        request.setAttribute("sts", hmString);
        lists = nsxSer.getAll();
        request.setAttribute("listNSX", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaSanXuat nsx = nsxSer.getData(request.getParameterMap());
        nsx.setId(id);
        HashMap<String, String> hmString = nsxSer.update(nsx);
        request.setAttribute("sts", hmString);
        lists = nsxSer.getAll();
        request.setAttribute("listNSX", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}
