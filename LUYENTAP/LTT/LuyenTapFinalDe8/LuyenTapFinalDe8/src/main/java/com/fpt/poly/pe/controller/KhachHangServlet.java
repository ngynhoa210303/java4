package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.service.KhachHangService;
import com.fpt.poly.pe.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/update",
        "/khach-hang/delete",
        "/khach-hang/view-update",
        "/khach-hang/view-add",
        "/khach-hang/add"
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private List<KhachHang> listKH = new ArrayList<>();
    private String ma;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiKhachHang(request, response);
        } else if (uri.contains("delete")) {
            this.removeKhachHang(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateKhachHang(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddKhachHang(request, response);
        } else {
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        }
    }

    private void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKH = khachHangService.getAll();
        if (listKH.isEmpty()){
            request.setAttribute("deleteAll", "Danh sách rỗng");
            request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
        }
        request.setAttribute("listKhachHang", listKH);
        request.getRequestDispatcher("/fe/view/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ma = request.getParameter("id");
        KhachHang khachHang = khachHangService.getOne(ma);
        request.setAttribute("kh", khachHang);
        request.getRequestDispatcher("/fe/view/update.jsp").forward(request, response);
    }

    private void viewAddKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/fe/view/add.jsp").forward(request, response);
    }

    private void removeKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("id");
        KhachHang khachHang = khachHangService.getOne(ten);
        khachHangService.delete(khachHang);
        request.setAttribute("kh", khachHang);
        request.setAttribute("messDelete", "Xóa thành công");
        this.hienThiKhachHang(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addKhachHang(request, response);
        } else if (uri.contains("update")) {
            this.updateKhachHang(request, response);
        }
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = khachHangService.getData(request.getParameterMap());
        HashMap<String, String> stringHashMap = khachHangService.add(khachHang);
        request.setAttribute("kh", khachHang);
        request.setAttribute("err", stringHashMap);
        List list = khachHangService.getAll();
        request.setAttribute("listKhachHang", list);
        request.setAttribute("mess", stringHashMap.get("mess"));
        request.getRequestDispatcher(stringHashMap.get("url")).forward(request, response);
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = khachHangService.getData(request.getParameterMap());
        khachHang.setId(khachHangService.getOne(ma).getId());
        khachHang.setMa(ma);
        HashMap<String, String> stringHashMap = khachHangService.update(khachHang);
        request.setAttribute("kh", khachHang);
        request.setAttribute("err", stringHashMap);
        List<KhachHang> list = khachHangService.getAll();
        request.setAttribute("listKhachHang", list);
        request.setAttribute("mess", stringHashMap.get("mess"));
        request.getRequestDispatcher(stringHashMap.get("url")).forward(request, response);
    }
}
