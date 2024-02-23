package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.ThucVat;
import com.fpt.poly.lab.service.ThucVatService;
import com.fpt.poly.lab.service.impl.ThucVatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ThucVatServlet", value = {
        "/thuc-vat/hien-thi-tat-ca",
        "/thuc-vat/tim-kiem",
        "/thuc-vat/remove",
        "/thuc-vat/add",
        "/thuc-vat/update",
        "/thuc-vat/view-update",
})
public class ThucVatServlet extends HttpServlet {
    List<ThucVat> listTV = new ArrayList<>();
    ThucVatService tvSer = new ThucVatServiceImpl();
    Long id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiTatCa(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiem(request, response);
        } else if (uri.contains("remove")) {
            this.removeTV(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThiTatCa(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Long.valueOf(request.getParameter("id"));
        ThucVat tv = tvSer.getOne(id);
        request.setAttribute("sv", tv);
        request.getRequestDispatcher("/lab5_6/view-update.jsp").forward(request, response);
    }

    private void removeTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Long.valueOf(request.getParameter("id"));
        ThucVat tv = tvSer.getOne(id);
        if (tvSer.delete(tv).equals("Xóa thành công")) {
            request.setAttribute("sv", tv);
            response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
        } else {
            this.hienThiTatCa(request, response);
        }

    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten=request.getParameter("tenSeach");
        String tuoiMinStr =request.getParameter("tuoiMin");
        String tuoiMaxStr =request.getParameter("tuoiMax");
        Integer tuoiMin=0;
        Integer tuoiMax=Integer.MAX_VALUE;
        if (!tuoiMinStr.isEmpty()){
            tuoiMin= Integer.parseInt(tuoiMinStr);
        }
        if(!tuoiMaxStr.isEmpty()){
            tuoiMax= Integer.parseInt(tuoiMaxStr);
        }
        List<ThucVat> listSearch=tvSer.listSearch(ten,tuoiMin,tuoiMax);
        request.setAttribute("listTV",listSearch);
//        response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
        request.getRequestDispatcher("/lab5_6/thucvats.jsp").forward(request, response);

    }


    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listTV = tvSer.getAll();
        request.setAttribute("listTV", listTV);
        request.getRequestDispatcher("/lab5_6/thucvats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addTV(request, response);
        } else {
            this.updateTV(request, response);
        }
    }

    private void updateTV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loaiCay = request.getParameter("loai");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String soTuoi = request.getParameter("tuoi");
        String khuVuc = request.getParameter("khuVuc");
//        id=Long.valueOf(request.getParameter("id"));
        ThucVat tv = tvSer.getOne(id);
        tv.setLoai(loaiCay);
        tv.setGioiTinh(Boolean.valueOf(gioiTinh));
        tv.setKhuVuc(khuVuc);
        tv.setTuoi(Integer.valueOf(soTuoi));
        tv.setTen(ten);
        if (tvSer.update(tv).equals("Sửa thành công")) {
//            request.setAttribute("sv", tv);
            response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
        } else {
            this.hienThiTatCa(request, response);
        }
    }

    private void addTV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String loaiCay = request.getParameter("loai");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String soTuoi = request.getParameter("tuoi");
        String khuVuc = request.getParameter("khuVuc");
        ThucVat tv = new ThucVat(loaiCay, ten, Boolean.valueOf(gioiTinh), Integer.valueOf(soTuoi), khuVuc);
        if (tvSer.add(tv).equals("Thêm thành công")) {
            request.setAttribute("sv", tv);
            response.sendRedirect("/thuc-vat/hien-thi-tat-ca");
        } else {
            this.hienThiTatCa(request, response);
        }
    }
}
