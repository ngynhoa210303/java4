package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.SanPhamService;
import com.fpt.poly.lab.service.impl.SanPhamServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view-all",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/tim-kiem",
        "/san-pham/add",
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> listSP = new ArrayList<>();
    private SanPhamService spService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("detail")) {
            this.detailSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSP(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiemSP(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private SanPham newSP(HttpServletRequest request) {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String loai = request.getParameter("loai");
        SanPham sp = new SanPham(Integer.valueOf(id), ma, ten, loai, Integer.valueOf(gia));
        return sp;
    }

    private void setStatus(HttpServletRequest request, SanPham sp) {
        request.setAttribute("sp", sp);
        if (String.valueOf(sp.getId()).isEmpty()) {
            request.setAttribute("stsID", "ID không để trống");
        }
        if (sp.getMa().isEmpty()) {
            request.setAttribute("stsMa", "Max không để trống");
        }
        if (sp.getTen().isEmpty()) {
            request.setAttribute("stsTen", "Tên không để trống");
        }
        if (String.valueOf(sp.getGia()).matches("[0-9]+")||sp.getGia()<150) {
            request.setAttribute("stsGia", "Gias là số nguyên và>150 ");
        }
    }

    private void timKiemSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tenSearch= request.getParameter("tenSearch");
        List<SanPham> listSearch = spService.listSearch(listSP, tenSearch);
        request.setAttribute("listSP", listSearch);
        request.getRequestDispatcher("/lab1_4/sanphams.jsp").forward(request,response);
    }

    private void viewUpdateSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id=request.getParameter("id");
//        request.setAttribute("index", id);
        request.setAttribute("sanPham", spService.getOneSP(listSP, Integer.valueOf(request.getParameter("id"))));
        request.getRequestDispatcher("/lab1_4/view-update.jsp").forward(request, response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        spService.removeSP(listSP, Integer.valueOf(id));
        response.sendRedirect("/san-pham/view-all");
    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("id");
        SanPham sanPham = spService.getOneSP(listSP, Integer.parseInt(index));
        request.setAttribute("sanPham", sanPham);
        this.viewAll(request, response);
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listSP.isEmpty()) {
            listSP = spService.listFake();
        }
        request.setAttribute("listSP", listSP);
        request.getRequestDispatcher("/lab1_4/sanphams.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSP(request, response);
        } else {
            this.addSP(request, response);
        }
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SanPham sp = this.newSP(request);
        if (spService.addSP(listSP, sp)) {
            response.sendRedirect("/san-pham/view-all");
//            request.getRequestDispatcher("/lab1_4/sanphams.jsp").forward(request,response);
        } else {
//            this.setStatus(request, sp);
            this.setStatus(request, sp);
            this.viewAll(request, response);
                   }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        int index = spService.getIndexByID(listSP, id);
        SanPham sp = this.newSP(request);
        if (spService.updateSP(listSP, index, sp)) {
            response.sendRedirect("/san-pham/view-all");
//            request.getRequestDispatcher("/lab1_4/sanphams.jsp").forward(request,response);
        } else {
            this.setStatus(request, sp);
            this.viewAll(request, response);    }
//        String id = request.getParameter("id");
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        String gia = request.getParameter("gia");
//        String loai = request.getParameter("loai");
////        SanPham sp = new SanPham(Integer.valueOf(id), ma, ten, loai, Integer.valueOf(gia));
////        SanPham sp = new GiangVien(id, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), diaChi);
//        SanPham sp=spService.findSPByID(listSP,id);
//        sp.setLoai(loai);
//        sp.setTen(ten);
//        sp.setMa(ma);
////        sp.setID(Integer.valueOf(id));
//        sp.setGia(Integer.valueOf(gia));
//        request.setAttribute("listSP", listSP);
//        request.getRequestDispatcher("/lab1_4/sanphams.jsp").forward(request, response);
//        int index  = Integer.parseInt(request.getParameter("index"));
//        String id = request.getParameter("id");

//      //B3: Set gia tri thuoc tinh cho doi SV
//        SanPham sp = new SanPham();
//        sp.setLoai(loai);
//        sp.setTen(ten);
//        sp.setMa(ma);
////        sp.setID(Integer.valueOf(id));
//        sp.setGia(Integer.valueOf(gia));
//
//        //B4 Update gia tri cho list
//        listSP.set(index, sp);
//
//        //B5 Chuyen ve trang hien thi
//        response.sendRedirect("/san-pham/view-all");
    }
}