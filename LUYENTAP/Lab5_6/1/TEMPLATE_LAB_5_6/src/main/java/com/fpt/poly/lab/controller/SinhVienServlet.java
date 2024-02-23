package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.service.SinhVienService;
import com.fpt.poly.lab.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/search",
        "/sinh-vien/search2DK",
        "/sinh-vien/detail",
        "/sinh-vien/remove",
        "/sinh-vien/view-update",
        "/sinh-vien/update",
        "/sinh-vien/view-add",
        "/sinh-vien/add",
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> lists = new ArrayList<>();
    private SinhVienService svSer = new SinhVienServiceImpl();
    private UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        }
//        else if (uri.contains("search")) {
//            this.searchSV(request, response);
//        }
        else if (uri.contains("search2DK")) {
            this.search2DK(request, response);
        } else if (uri.contains("remove")) {
            this.removeSV(request, response);
        } else if (uri.contains("detail")) {
            this.detailSV(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else {
            this.hienThi(request, response);
        }

    }

    private void search2DK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenSearch1");
//        String gioiTinhSearch = request.getParameter("gioiTinhSearch");
        Boolean gioiTinh = null;
        String gioiTinhSearch = request.getParameter("gioiTinhSearch");
        if (gioiTinhSearch != null && !gioiTinhSearch.isEmpty()) {
            gioiTinh = Boolean.valueOf(gioiTinhSearch);
        }
        List<SinhVien>listSearch2DK = svSer.listSearch2DK(ten,gioiTinh );
        request.setAttribute("listSV", listSearch2DK);
        request.getRequestDispatcher("/btvn10/sinhviens.jsp").forward(request, response);
//        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void removeSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        SinhVien sv = svSer.getOne(id);
        svSer.deleteSV(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/btvn10/view-add.jsp").forward(request, response);
        ;
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        SinhVien sv = svSer.getOne(id);
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/btvn10/view-update.jsp").forward(request, response);
    }

    private void detailSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien gv = svSer.getOne(UUID.fromString(request.getParameter("id")));
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/btvn10/view-detail.jsp").forward(request, response);
    }

//    private void searchSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String tenSearch = request.getParameter("tenSearch");
//        List<SinhVien> lists = svSer.listSearch(tenSearch);
//        request.setAttribute("listSV", lists);
//        request.getRequestDispatcher("/btvn10/sinhviens.jsp").forward(request, response);
//    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = svSer.getAll();
        request.setAttribute("listSV", lists);
        request.getRequestDispatcher("/btvn10/sinhviens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSV(request, response);
        } else if (uri.contains("update")) {
            this.updateSV(request, response);
        }
    }

    private SinhVien newSV(HttpServletRequest request) {
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        SinhVien sv = SinhVien.builder()
                .ten(ten)
                .tuoi(Long.valueOf(tuoi))
                .diaChi(diaChi)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .build();
        return sv;
    }

    private void updateSV(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        SinhVien nsv = svSer.getOne(id);
        nsv.setTuoi(Long.valueOf(tuoi));
        nsv.setGioiTinh(Boolean.valueOf(gioiTinh));
        nsv.setDiaChi(diaChi);
        nsv.setTen(ten);
        if (svSer.updateSV(nsv).equals("Update thành công")) {
//        lists=svSer.updateSV(nsv);
            request.setAttribute("listSV", lists);
            response.sendRedirect("/sinh-vien/hien-thi");
        } else {
            this.viewUpdate(request, response);
        }
//        } else {
//            // Xử lý khi giá trị tham số "id" thiếu hoặc trống
//        }
    }

    private void addSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sv = this.newSV(request);
        if (svSer.addSV(sv).equals("Thêm thành công")) {
//            request.setAttribute("listSV", lists);
            response.sendRedirect("/sinh-vien/hien-thi");
        } else {
//            this.setStatus(request,gv);
            this.viewAdd(request, response);
        }
    }
}
