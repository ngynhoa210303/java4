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
        "/cua-hang/add",
        "/cua-hang/delete"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangService chService = new CuaHangServiceImpl();
    private List<CuaHang> lists = new ArrayList<>();
    private UUID id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        CuaHang ch = chService.getOne(id);
        chService.delete(ch);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = chService.getAll();
        if (lists.isEmpty()) {
            request.setAttribute("message", "Không có dữ liệu");
        }
        request.setAttribute("lists", lists);
        request.getRequestDispatcher("/fe/view/cuahangs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addCH(request, response);
        }
    }

    private void addCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang ch = chService.getData(request.getParameterMap());
        HashMap<String, String> hashMap = chService.addCH(ch);
        request.setAttribute("mess", hashMap.get("mess"));
        request.setAttribute("sts", hashMap);
        this.hienThi(request, response);
    }
}
