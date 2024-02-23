package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.DongVat;
import com.fpt.poly.lab.service.DongVatService;
import com.fpt.poly.lab.service.impl.DongVatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongVatServlet", value = {
        "/dong-vat/hien-thi",
        "/dong-vat/add",
        "/dong-vat/remove",
        "/dong-vat/update",
        "/dong-vat/view-update",
        "/dong-vat/view-add",
        "/dong-vat/search",


})
public class DongVatServlet extends HttpServlet {
    List<DongVat> listDV = new ArrayList<>();
    DongVatService dvSer = new DongVatServiceImpl();
    UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("remove")) {
            this.removeDT(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void removeDT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        id = UUID.fromString(request.getParameter("id"));
        DongVat mt = dvSer.getOne(id);
        if (dvSer.delete(mt).equals("Xóa thành công")) {
            request.setAttribute("mt", mt);
            response.sendRedirect("/dong-vat/hien-thi");
        } else {
//            JOptionPane.showMessageDialog(null,"Xóa thất bại");
            this.hienThi(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        DongVat dv = dvSer.getOne(id);
        request.setAttribute("mt", dv);
        request.getRequestDispatcher("/lab5_6/view-update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/lab5_6/dongvats.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDV = dvSer.getAll();
        request.setAttribute("listDV", listDV);
        request.getRequestDispatcher("/lab5_6/dongvats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addMT(request, response);
        } else {
            this.updateMT(request, response);
        }
    }

    private void stsTrong(HttpServletRequest request, DongVat mt) {
        request.setAttribute("mt", mt);
        if (mt.getTen().trim().isEmpty()) {
            request.setAttribute("stsTen", "Tên trống");
        }if (mt.getTuoi()<=1) {
            request.setAttribute("stsTuoi1", "Tuổi > 1");
        }if (mt.getKhuVucSong().trim().isEmpty()) {
            request.setAttribute("stsKhuVucSong", "KVS trống");
        }
//
//        if (mt.getBoNho().trim().isEmpty()) {
//            request.setAttribute("stsBoNho", "Bộ nhớ trống");
//        }
    }

    private void updateMT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String khuVucSong = request.getParameter("khuVucSong");
        String gioiTinh = request.getParameter("gioiTinh");
        String loai = request.getParameter("loai");
        DongVat dv = dvSer.getOne(id);
        dv.setTen(ten);
        dv.setTuoi(Integer.valueOf(tuoi));
        dv.setKhuVucSong(khuVucSong);
        dv.setLoai(loai);
        dv.setGioiTinh(Boolean.valueOf(gioiTinh));
        if (dvSer.update(dv).equals("Sửa thành công")) {
            response.sendRedirect("/dong-vat/hien-thi");
        } else {
//            this.stsTrong(request, mt);
            this.viewUpdate(request, response);
        }
    }

    private void addMT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String khuVucSong = request.getParameter("khuVucSong");
        String gioiTinh = request.getParameter("gioiTinh");
        String loai = request.getParameter("loai");

        DongVat mt = new DongVat(ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), khuVucSong, loai);

        if (dvSer.add(mt).equals("Thêm thành công")) {
            response.sendRedirect("/dong-vat/hien-thi");
        } else {
            this.stsTrong(request,mt);
            this.viewAdd(request, response);
        }
    }
}
