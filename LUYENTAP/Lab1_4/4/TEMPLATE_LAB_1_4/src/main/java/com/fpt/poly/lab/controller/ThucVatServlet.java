package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.ThucVat;
import com.fpt.poly.lab.service.ThucVatService;
import com.fpt.poly.lab.service.impl.ThucVatServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ThucVatServlet", value = {
        "/thuc-vat/hien-thi-tat-ca",
        "/thuc-vat/ban-dau",
        "/thuc-vat/tim-kiem",
        "/thuc-vat/add",
        "/thuc-vat/remove",
        "/thuc-vat/view-update",
        "/thuc-vat/update",
        "/thuc-vat/detail",
})
public class ThucVatServlet extends HttpServlet {
    List<ThucVat> listTV = new ArrayList<>();
    ThucVatService tvService = new ThucVatServiceImpl();

    private ThucVat newSP(HttpServletRequest request) {
        String id = request.getParameter("id");
        String loaiCay = request.getParameter("loaiCay");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("soTuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String khuVuc = request.getParameter("khuVuc");
        ThucVat tv = new ThucVat(Integer.valueOf(id), loaiCay, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), khuVuc);
        return tv;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiTatCa(request, response);
        }else if (uri.contains("ban-dau")) {
            this.banDau(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiem(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThiTatCa(request, response);
        }
    }

    private void banDau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/lab1_4/thucvats.jsp").forward(request, response);

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        ThucVat tv = tvService.getOne(listTV, id);
        request.setAttribute("tvat", tv);
        request.setAttribute("index", id);
        request.getRequestDispatcher("/lab1_4/view-update.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        tvService.remove(listTV, Integer.valueOf(id));
        response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenSearch");
        String min = request.getParameter("tuoiMin");
        String max = request.getParameter("tuoiMax");
        List<ThucVat> listSearch = tvService.search(listTV, ten, min, max);
        request.setAttribute("listTV", listSearch);
        request.getRequestDispatcher("/lab1_4/thucvats.jsp").forward(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listTV.isEmpty()) {
            listTV = tvService.listData();
        }
        request.setAttribute("listTV", listTV);
        request.getRequestDispatcher("/lab1_4/thucvats.jsp").forward(request, response);
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ThucVat tv = this.newSP(request);
        if (tvService.addTV(listTV, tv)) {
            response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
        } else {
            this.hienThiTatCa(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ThucVat tv = this.newSP(request);
        if (tvService.updateTV(listTV, Integer.parseInt(request.getParameter("index")), tv)) {
            response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
       } else {
            this.hienThiTatCa(request, response);
        }
    }
}
