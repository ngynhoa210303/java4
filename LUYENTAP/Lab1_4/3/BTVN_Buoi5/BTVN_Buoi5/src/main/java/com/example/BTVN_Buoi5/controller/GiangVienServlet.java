package com.example.BTVN_Buoi5.controller;


import com.example.BTVN_Buoi5.entity.GiangVien;
import com.example.BTVN_Buoi5.service.GiangVienService;
import com.example.BTVN_Buoi5.service.impl.GiangVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/view-update",
        "/giang-vien/update",
        "/giang-vien/tim-kiem",
        "/giang-vien/add"
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienServiceImpl();
    private List<GiangVien> listGV = giangVienService.fakeData();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiGV(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiemGV(request, response);
        } else if (uri.contains("remove")) {
            this.removeGV(request, response);
        } else if (uri.contains("detail")) {
            this.detailGV(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGV(request, response);
        } else {
            this.hienThiGV(request, response);
        }
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

    private void addGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GiangVien giangVien = this.newGV(request);
        if (giangVienService.addGV(listGV, giangVien)) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            this.setStatus(request, giangVien);
            this.hienThiGV(request, response);
        }
    }

    private void updateGV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maGV = request.getParameter("maGV");
        int index = giangVienService.getIndexByMaGV(listGV, maGV);
        GiangVien giangVien = this.newGV(request);
        if (giangVienService.updateGV(listGV, index, giangVien)) {
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        } else {
            this.setStatus(request, giangVien);
            request.setAttribute("gv", giangVien);
            request.getRequestDispatcher("/view/updateGV.jsp").forward(request, response);
        }
    }

    private void detailGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.valueOf(request.getParameter("id"));
        GiangVien giangVien = listGV.get(index);
        request.setAttribute("gv", giangVien);
        this.hienThiGV(request, response);
    }

    private void removeGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.valueOf(request.getParameter("id"));
        giangVienService.removeGV(listGV, index);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void timKiemGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenSearch");
        String min = request.getParameter("tuoiMin");
        String max = request.getParameter("tuoiMax");
        List<GiangVien> listSearch = giangVienService.searchGV(listGV, ten, min, max);
        request.setAttribute("listGiangVien", listSearch);
        request.getRequestDispatcher("/view/trang-chu.jsp").forward(request, response);
    }

    private void hienThiGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listGV.isEmpty()) {
            listGV = giangVienService.fakeData();
        }
        request.setAttribute("listGiangVien", listGV);
        request.getRequestDispatcher("/view/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdateGV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.valueOf(request.getParameter("id"));
        GiangVien giangVien = listGV.get(index);
        request.setAttribute("gv", giangVien);
        request.getRequestDispatcher("/view/updateGV.jsp").forward(request, response);
    }

    private void setStatus(HttpServletRequest request, GiangVien gv) {
        request.setAttribute("gv", gv);
        if (gv.getMaGV().isEmpty()) {
            request.setAttribute("statusMaGV", "MaGV khong duoc de trong");
        }
        if (gv.getTenGV().isEmpty()) {
            request.setAttribute("statusTenGV", "TenGV khong duoc de trong");
        }
        if (!String.valueOf(gv.getTuoi()).matches("[0-9]+") || gv.getTuoi() < 25) {
            request.setAttribute("statusTuoi", "Tuoi phai la so nguyen va >= 25");
        }
        if (gv.getQueQuan().isEmpty()) {
            request.setAttribute("statusQueQuan", "Que quan khong duoc de trong");
        }
    }

    private GiangVien newGV(HttpServletRequest request) {
        String maGV = request.getParameter("maGV");
        String tenGV = request.getParameter("tenGV");
        int tuoi;
        try {
            tuoi = Integer.valueOf(request.getParameter("tuoi"));
        } catch (Exception exception) {
            tuoi = 0;
        }
        String queQuan = request.getParameter("queQuan");
        GiangVien giangVien = new GiangVien(maGV, tenGV, tuoi, queQuan);
        return giangVien;
    }
}
