package com.fpt.poly.pe.controller;

import com.fpt.poly.pe.entity.CuaHang;
import com.fpt.poly.pe.service.CuaHangService;
import com.fpt.poly.pe.service.impl.CuaHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/viewbd",
        "/cua-hang/view-add",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/delete",
        "/cua-hang/view-update",
        "/cua-hang/update",
})
public class CuaHangServlet extends HttpServlet {
    private List<CuaHang> lists = new ArrayList<>();
    private CuaHangService chService = new CuaHangServiceImpl();
    private UUID id;
    private String ma;
//    private int liss = lists.size();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("viewbd")) {
            this.viewBD(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void viewBD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = null;
        request.getRequestDispatcher("/fe/view/cuahangs.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        id = UUID.fromString(request.getParameter("id"));
//        CuaHang ch = chService.getOne(id);
//        chService.delete(ch);
//        this.hienThi(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        id = UUID.fromString(request.getParameter("id"));
//        CuaHang ch = chService.getOne(id);
//        request.setAttribute("detail", ch);
//        this.hienThi(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        id = UUID.fromString(request.getParameter("id"));
        ma = request.getParameter("id");
        CuaHang ch = chService.getOne(ma);
        request.setAttribute("detail", ch);
//        request.setAttribute("mess", "Xóa thành công");
        request.getRequestDispatcher("/fe/view/view-update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/fe/view/view-add.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        lists = chService.getAll();
        if (lists.isEmpty()) {
            request.setAttribute("message", "Không có bản ghi nào");
        } else {
            request.setAttribute("listCH", lists);
        }
        request.getRequestDispatcher("/fe/view/cuahangs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        String thanhPho = request.getParameter("thanhPho");
//        String diaChi = request.getParameter("diaChi");
////        CuaHang ch = new CuaHang();
//        CuaHang ch = new CuaHang(ma, ten, thanhPho, diaChi);
        CuaHang ch = chService.getData(request.getParameterMap());
        ch.setId(chService.getOne(ma).getId());
//        ma=request.getParameter("id");
        ch.setMa(ma);
        HashMap<String, String> hm = chService.update(ch);
        request.setAttribute("mess", hm.get("mess"));
        if (hm.get("mess").equalsIgnoreCase("Update thanh cong")) {
            this.hienThi(request, response);
        } else {
            request.setAttribute("detail", ch);
            request.setAttribute("sts", hm);
            request.getRequestDispatcher("/fe/view/view-add.jsp").forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        String thanhPho = request.getParameter("thanhPho");
//        String diaChi = request.getParameter("diaChi");
//        CuaHang ch = new CuaHang(ma, ten, thanhPho, diaChi);
        CuaHang ch = chService.getData(request.getParameterMap());
//        ch.setMa("CH" + (++liss));
        HashMap<String, String> hm = chService.add(ch);
        request.setAttribute("mess", hm.get("mess"));
        request.setAttribute("detail", ch);
        if (hm.get("mess").equalsIgnoreCase("Add thanh cong")) {
            this.hienThi(request, response);
        } else {
            request.setAttribute("sts", hm);
            request.getRequestDispatcher("/fe/view/view-add.jsp").forward(request, response);
        }
    }
}
