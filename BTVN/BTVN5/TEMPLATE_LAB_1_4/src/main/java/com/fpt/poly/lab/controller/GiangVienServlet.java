package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.GiangVien;
import com.fpt.poly.lab.service.GiangVienService;
import com.fpt.poly.lab.service.impl.GiangVienServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi", // GET
        "/giang-vien/search", // GET
        "/giang-vien/remove", // GET
        "/giang-vien/detail", // GET
        "/giang-vien/giang-vien-nu", // GET
        "/giang-vien/view-update", // GET
        "/giang-vien/view-add", // GET
        "/giang-vien/add", // POST
        "/giang-vien/update" //POST
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService gvService = new GiangVienServiceImpl();
    private List<GiangVien> listGV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("search")) {
            // search du lieu
            this.searchGiangVien(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            // search du lieu
            this.giangVienNu(request, response);
        } else if (uri.contains("remove")) {
            // Remove du lieu
            this.removeGiangVien(request, response);
        } else if (uri.contains("detail")) {
            // detail du lieu
            this.detailGiangVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAddGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            // hien thi form update
            this.viewUpdateGiangVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiGiangVien(request, response);
        }
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GiangVien> listNu = gvService.listNu(listGV, true);
        request.setAttribute("listGV", listNu);
        request.getRequestDispatcher("/lab1_4/giangviens.jsp").forward(request, response);

    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        GiangVien giangVien = gvService.findGiangVienByID(listGV,id);
        GiangVien giangVien = gvService.getOne(listGV, Integer.valueOf(id));
        request.setAttribute("gv", giangVien);
        request.getRequestDispatcher("/lab1_4/update-giang-vien.jsp").forward(request, response);
    }

    private void viewAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/lab1_4/add-giang-vien.jsp").forward(request, response);
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        GiangVien giangVien = gvService.findGiangVienByID(listGV,id);
        GiangVien giangVien = gvService.getOne(listGV, Integer.parseInt(id));
        request.setAttribute("sv", giangVien);
        request.getRequestDispatcher("/lab1_4/detail-giang-vien.jsp").forward(request, response);
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
//    gvService.removeGiangVien(listGV,id);
        gvService.removeGV(listGV, Integer.valueOf(id));
//    chuyen lai trang hien thi
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenSearch");
        List<GiangVien> listSearch = gvService.listSearch(listGV, ten);
        request.setAttribute("listGV", listSearch);
        request.getRequestDispatcher("/lab1_4/giangviens.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listGV.isEmpty()) {
            listGV = gvService.fakeData();
        }
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/lab1_4/giangviens.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addGiangVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateGiangVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiGiangVien(request, response);
        }
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
//        GiangVien giangVien = new GiangVien(id, ten, Integer.valueOf(tuoi), Boolean.parseBoolean(gioiTinh), diaChi);
//        gvService.updateGV(id,listGV,giangVien);
        GiangVien giangVien = gvService.findGiangVienByID(listGV, id);
        giangVien.setTuoi(Integer.valueOf(tuoi));
        giangVien.setGioiTinh(Boolean.valueOf(gioiTinh));
        giangVien.setDiaChi(diaChi);
        giangVien.setTen(ten);
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/lab1_4/giangviens.jsp").forward(request, response);
//        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy toàn bộ giá trị từ form
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
//        GiangVien giangVien = GiangVien.builder()
//                .ten(ten)
//                .id(id)
//                .tuoi(Integer.valueOf(tuoi))
//                .diaChi(diaChi)
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .build();
        GiangVien giangVien = new GiangVien(id, ten, Integer.valueOf(tuoi), Boolean.valueOf(gioiTinh), diaChi);
        listGV.add(giangVien);
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/lab1_4/giangviens.jsp").forward(request, response);
    }
}
