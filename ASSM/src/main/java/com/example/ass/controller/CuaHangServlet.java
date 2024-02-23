package com.example.ass.controller;

import com.example.ass.entity.CuaHang;
import com.example.ass.service.CuaHangService;
import com.example.ass.service.impl.CuaHangServiceImpl;
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

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi-tat-ca",
        "/cua-hang/remove",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/update",
        "/cua-hang/view-update",
})
public class CuaHangServlet extends HttpServlet {
    private List<CuaHang> lists = new ArrayList<>();
    private UUID id;
    private CuaHangService chSer = new CuaHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThi(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        CuaHang ch = chSer.getOne(id);
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/view/cuahang/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        CuaHang ch = chSer.getOne(id);
        request.setAttribute("ch", ch);
        this.hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        CuaHang ch = chSer.getOne(id);
        chSer.delete(ch);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = chSer.getAll();
        request.setAttribute("listCH", lists);
        request.getRequestDispatcher("/view/cuahang/cuahangs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang ch = chSer.getData(request.getParameterMap());
        HashMap<String, String> hashMapStr = chSer.add(ch);
        request.setAttribute("ch", ch);
        request.setAttribute("sts", hashMapStr);
        lists = chSer.getAll();
        request.setAttribute("listCH", lists);
        request.setAttribute("mess", hashMapStr.get("mess"));
        request.getRequestDispatcher(hashMapStr.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang ch = chSer.getData(request.getParameterMap());
        ch.setId(id);
        HashMap<String, String> hashMapStr = chSer.update(ch);
        request.setAttribute("sts", hashMapStr);
        lists = chSer.getAll();
        request.setAttribute("listCH", lists);
        request.setAttribute("mess", hashMapStr.get("mess"));
        request.getRequestDispatcher(hashMapStr.get("url")).forward(request, response);
    }
}
