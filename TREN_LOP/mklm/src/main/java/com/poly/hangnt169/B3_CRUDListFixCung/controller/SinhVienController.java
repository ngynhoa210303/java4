package com.poly.hangnt169.B3_CRUDListFixCung.controller;
/**
 * @author hangnt169
 */

import com.poly.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B3_CRUDListFixCung.service.SinhVienService;
import com.poly.hangnt169.B3_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search", // GET
        "/sinh-vien/remove", // GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/view-add", // GET
        "/sinh-vien/add", // POST
        "/sinh-vien/update" //POST
})
public class SinhVienController extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> sinhViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String use= (String) session.getAttribute("uname");
        if (use == null) {
            response.sendRedirect("/Login14Servlet");
        }else {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // search du lieu
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            // Remove du lieu
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            // detail du lieu
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            // hien thi form add
            this.viewAddSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            // hien thi form update
            this.viewUpdateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay duoc gia tri o tren duong dan
        if (uri.contains("add")) {
            // hien thi du lieu
            this.addSinhVien(request, response);
        } else if (uri.contains("update")) {
            // search du lieu
            this.updateSinhVien(request, response);
        } else {
            // neu khong vao cac case tren thi quay lai trang hien thi
            this.hienThiSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
//        setObj
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv=request.getParameter("mssv");
        String ten=request.getParameter("ten");
        String tuoi=request.getParameter("tuoi");
        String gioiTinh=request.getParameter("gioiTinh");
        String diaChi=request.getParameter("diaChi");
        SinhVien sinhVien=SinhVien.builder()
                .ten(ten)
                .diaChi(diaChi)
                .mssv(mssv)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .tuoi(Integer.valueOf(tuoi))
                .build();
        sinhViens.add(sinhVien);
        request.setAttribute("listSinhVien", sinhViens);
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("id");//id bên sinhviens.jsp
        sinhVienService.removeSinhVien(sinhViens, mssv);
        SinhVien sinhVien=sinhVienService.findSinhVien(sinhViens,mssv);
        request.setAttribute("sv",sinhVien);
        request.getRequestDispatcher("/buoi3/update-sinh-vien.jsp").forward(request, response);
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi3/add-sinh-vien").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("id");//id bên sinhviens.jsp
        sinhVienService.removeSinhVien(sinhViens, mssv);
        SinhVien sinhVien=sinhVienService.findSinhVien(sinhViens,mssv);
        request.setAttribute("sv",sinhVien);
        request.getRequestDispatcher("/buoi3/detail-sinh-vien.jsp").forward(request, response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //lấy giá trị từ jsp về serverlet
        String mssv = request.getParameter("id");//id bên sinhviens.jsp
        sinhVienService.removeSinhVien(sinhViens, mssv);
//      C1: Copy code hàm hiển thị
      if (sinhViens.isEmpty()) {
            sinhViens = sinhVienService.fakeData();
        }
        request.setAttribute("listSinhVien", sinhViens);
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request, response);
        //C2:Send Redirect
//        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
        List<SinhVien> listSearch = new ArrayList<>();
//        int a = Integer.parseInt(txtTuoiMin.getText());
//        int b = Integer.parseInt(txtTuoiMax.getText());
        String ten = request.getParameter("ten");
        for (SinhVien x : sinhViens) {
            if (x.getTen().contains(ten)) {
                listSearch.add(x);
            }
        }
        request.setAttribute("listSearch", sinhViens);
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (sinhViens.isEmpty()) {
            sinhViens = sinhVienService.fakeData();
        }

        request.setAttribute("listSinhVien", sinhViens);
        request.getRequestDispatcher("/buoi3/sinhviens.jsp").forward(request, response);
    }
}
