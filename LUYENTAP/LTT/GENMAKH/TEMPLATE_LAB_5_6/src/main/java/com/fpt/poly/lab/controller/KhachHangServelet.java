package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.request.KhachHangRequest;
import com.fpt.poly.lab.service.KhachHangService;
import com.fpt.poly.lab.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "khachHangServelet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/search",
        "/khach-hang/remove",
        "/khach-hang/detail",
        "/khach-hang/view-update",
        "/khach-hang/add",
        "/khach-hang/update"
})
public class KhachHangServelet extends HttpServlet {
    private List<KhachHang> listKhachHang = new ArrayList<>();
    private KhachHangService service = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThikh(request, response);
        } else if (uri.contains("search")) {
            this.searchKh(request, response);
        } else if (uri.contains("remove")) {
            this.removekh(request, response);
        } else if (uri.contains("detail")) {
            this.detailkh(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdatekh(request, response);
        } else {
            this.hienThikh(request, response);
        }
    }

    private void viewUpdatekh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viTri = request.getParameter("id");
        KhachHang kh = service.getOne(UUID.fromString(viTri));
        request.setAttribute("khachHang", kh);
        request.getRequestDispatcher("/update-kh.jsp").forward(request, response);
    }

    private void removekh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viTri = request.getParameter("id");
        service.delete(UUID.fromString(viTri));
        List<KhachHang> kh = service.getAll();
        request.setAttribute("listKH", kh);
        request.getRequestDispatcher("/khachhang.jsp").forward(request, response);
    }

    private void searchKh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenSearch");
        List<KhachHang> findKh = service.search(ten);
        request.setAttribute("listKH", findKh);
        request.getRequestDispatcher("/khachhang.jsp").forward(request, response);
    }

    private void detailkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viTri = request.getParameter("id");
        KhachHang kh = service.getOne(UUID.fromString(viTri));
        request.setAttribute("khachHang", kh);
        request.setAttribute("listKH", listKhachHang);
        request.getRequestDispatcher("/khachhang.jsp").forward(request, response);
    }


    private void hienThikh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKhachHang = service.getAll();
        request.setAttribute("listKH", listKhachHang);
        request.getRequestDispatcher("/khachhang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addkh(request, response);
        } else if (uri.contains("update")) {
            this.updatekh(request, response);
        } else {
            this.hienThikh(request, response);
        }
    }

    private void updatekh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        KhachHangRequest kh = new KhachHangRequest( ma,ten, tenDem, ho, sdt, diaChi);
        service.update(kh, UUID.fromString(id));
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void addkh(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = String.valueOf(service.genMaKhachHang());
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        KhachHangRequest khachHangRequest = new KhachHangRequest(ma,ten, tenDem, ho, sdt, diaChi);
        khachHangRequest.setMa("KH"+ma);
        HashMap<String, String> errors = service.add(khachHangRequest);
        request.setAttribute("errors", errors);
        request.setAttribute("errorsSDT", errors);
        if (errors.isEmpty()) {
            request.setAttribute("listKH", listKhachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        } else {
            request.getRequestDispatcher("/khachhang.jsp").forward(request, response);

        }

    }
}
