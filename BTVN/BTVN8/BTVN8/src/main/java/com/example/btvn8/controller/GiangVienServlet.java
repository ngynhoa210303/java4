package com.example.btvn8.controller;

import com.example.btvn8.entity.GiangVien;
import com.example.btvn8.service.GiangVienService;
import com.example.btvn8.service.impl.GiangVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/update",
        "/giang-vien/view-update",
        "/giang-vien/tim-kiem",
        "/giang-vien/add",
})
public class GiangVienServlet extends HttpServlet {
    private List<GiangVien> lists = new ArrayList<>();
    private GiangVienService gvService = new GiangVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiTatCa(request, response);
        } else if (uri.contains("detail")) {
            this.detailGV(request, response);
        } else if (uri.contains("remove")) {
            this.removeGV(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.searchGV(request, response);
        } else {
            this.hienThiTatCa(request, response);
        }
    }


    private void searchGV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("tenSearch");
        String tuoiMinSt = request.getParameter("tuoiMin");
        String tuoiMaxSt = request.getParameter("tuoiMax");
        Long tuoiMin = 0L;
        Long tuoiMax = Long.MAX_VALUE;
        if (tuoiMinSt.isEmpty()) {
            tuoiMin = Long.valueOf(tuoiMin);
        }
        if (tuoiMaxSt.isEmpty()) {
            tuoiMax = Long.valueOf(tuoiMax);
        }
        List<GiangVien> lists = gvService.listSearch(ten, tuoiMin, tuoiMax);
        request.setAttribute("listGV", lists);
        request.getRequestDispatcher("/btvn8/giangviens.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        GiangVien gv = gvService.getOne(id);
        request.setAttribute("gVien", gv);
        request.getRequestDispatcher("/btvn8/view-update.jsp").forward(request, response);
    }

    private void removeGV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        GiangVien gv = gvService.getOne(id);
        gvService.del(gv);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void detailGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        GiangVien gv=gvService.getOne(id);
        if (id != null) {
            GiangVien gv = gvService.getOne(id);
            request.setAttribute("gVien", gv);
        }
        this.hienThiTatCa(request, response);
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = gvService.getAll();
        request.setAttribute("listGV", lists);
        request.getRequestDispatcher("/btvn8/giangviens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateGV(request, response);
        } else {
            this.addGV(request, response);
        }
    }

    private GiangVien newGV(HttpServletRequest request) {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String queQuan = request.getParameter("queQuan");
        GiangVien gv = new GiangVien(ma, ten, Long.valueOf(tuoi), Boolean.valueOf(gioiTinh), queQuan);
        return gv;
    }

    private void setStatus(HttpServletRequest request, GiangVien gv) {
        request.setAttribute("gv", gv);
        if (gv.getMssv().isEmpty()) {
            request.setAttribute("stsMa", "Mã không để trống");
        }
        if (gv.getTen().isEmpty()) {
            request.setAttribute("stsTen", "Tên không để trống");
        }
        if (String.valueOf(gv.getTuoi()).isEmpty()) {
            request.setAttribute("stsTuoiTrong", "Tuổi không để trống");
        }
        if (!String.valueOf(gv.getTuoi()).matches("\\d+") || gv.getTuoi() < 25) {
            request.setAttribute("stsTuoi", "Tuổi là số nguyên và >25 ");
        }
        if (!gv.getTen().matches("^[a-z A-Z]+$")) {
            request.setAttribute("stsTenDD", "Tên là chữ");
        }
        if (gv.getQueQuan().isEmpty()) {
            request.setAttribute("stsQueQuan", "Quê quán không để trống");
        }
    }

    private void addGV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GiangVien gv = this.newGV(request);
        if (gvService.addGV(gv)) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            this.setStatus(request, gv);
            this.hienThiTatCa(request, response);
        }
    }

    private void updateGV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GiangVien gv = this.newGV(request);
        if (gvService.updateGV(gv)) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            this.setStatus(request, gv);
            this.hienThiTatCa(request, response);
        }
    }
}
