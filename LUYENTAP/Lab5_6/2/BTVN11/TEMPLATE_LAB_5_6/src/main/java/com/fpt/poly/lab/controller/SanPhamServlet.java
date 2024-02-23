package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.SanPhamService;
import com.fpt.poly.lab.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SPServlet", value = {
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/tim-kiem",
        "/san-pham/hien-thi-tat-ca",
        "/san-pham/add",
        "/san-pham/update",
})
public class SanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("detail")) {
            this.detailSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSP(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiem(request, response);
        } else if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiSP(request, response);
        } else {
            this.hienThiSP(request, response);
        }
    }

    List<SanPham> lists = new ArrayList<>();
    SanPhamService spService = new SanPhamServiceImpl();
    Long id;

    private void hienThiSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     lists=spService.getAll();
     request.setAttribute("listSP",lists);
     request.getRequestDispatcher("/lab5_6/sanphams.jsp").forward(request,response);
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten=request.getParameter("tenSearch");
        List<SanPham>listSearch=spService.search(ten);
        request.setAttribute("listSP",listSearch);
        request.getRequestDispatcher("/lab5_6/sanphams.jsp").forward(request,response);
    }

    private void viewUpdateSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        id=Long.valueOf(request.getParameter("id"));
        SanPham sp=spService.getOne(id);
        request.setAttribute("sp",sp);
        request.getRequestDispatcher("/lab5_6/view-update.jsp").forward(request,response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        id=Long.valueOf(request.getParameter("id"));
        SanPham sp=spService.getOne(id);
        if(spService.delete(sp).equals("Xóa thành công")){
            response.sendRedirect("/san-pham/hien-thi-tat-ca");
        }else {
            response.sendRedirect("/san-pham/delete");
        }
    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id=Long.valueOf(request.getParameter("id"));
        SanPham sp=spService.getOne(id);
        request.setAttribute("sp",sp);
        this.hienThiSP(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSP(request, response);
        } else {
            this.updateSP(request, response);
        }
    }
    private void setStt(HttpServletRequest request,SanPham sp){
        request.setAttribute("sp",sp);
        if (sp.getMa().trim().isEmpty()){
            request.setAttribute("stsMa","Mã trống");
        }if (sp.getTen().trim().isEmpty()){
            request.setAttribute("stsTen","Tên trống");
        }if (!sp.getTen().matches("[a-zA-Z\\s]")){
            request.setAttribute("stsTenNN","Tên phải là chữ");
        }if (Float.isNaN(sp.getGia())) {
            request.setAttribute("stsGia", "Giá trống");
        }if (sp.getGia()<=25) {
            request.setAttribute("stsGiaNN", "Giá phải là số nguyên dương >25");
        }
    }
    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String gia=request.getParameter("gia");
        String loai=request.getParameter("loai");
//        id=Long.valueOf(request.getParameter("id"));
        SanPham sp=spService.getOne(id);
        sp.setTen(ten);
        sp.setMa(ma);
        sp.setGia(Float.valueOf(gia));
        sp.setLoai(loai);
        if(spService.update(sp).equals("Sửa thành công")){
            response.sendRedirect("/san-pham/hien-thi-tat-ca");
        }else {
            this.setStt(request,sp);
            this.hienThiSP(request,response);
        }
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String gia=request.getParameter("gia");
        String loai=request.getParameter("loai");
        float giaFloat;
        if (gia == null || gia.isEmpty()) {
            giaFloat = Float.NaN;
        } else {
            giaFloat = Float.parseFloat(gia);
        }
        SanPham sp=new SanPham(ma,ten,loai,giaFloat);
        if(spService.add(sp).equals("Thêm thành công")){
            response.sendRedirect("/san-pham/hien-thi-tat-ca");
        }else {
            this.setStt(request,sp);
            this.hienThiSP(request,response);
        }
    }
}
