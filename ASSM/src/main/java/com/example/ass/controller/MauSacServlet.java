package com.example.ass.controller;

import com.example.ass.entity.MauSac;
import com.example.ass.service.MauSacService;
import com.example.ass.service.impl.MauSacServiceImpl;
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

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi-tat-ca",
        "/mau-sac/remove",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/update",
        "/mau-sac/view-update",
})
public class MauSacServlet extends HttpServlet {
    private List<MauSac> lists = new ArrayList<>();
    private MauSacService msSer = new MauSacServiceImpl();
    private UUID id;

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
        MauSac ms = msSer.getOne(id);
        request.setAttribute("ms", ms);
        request.getRequestDispatcher("/view/mausac/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        id = UUID.fromString(request.getParameter("id"));
        MauSac ms = msSer.getOne(id);
        request.setAttribute("ms", ms);
        this.hienThi(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        MauSac ms = msSer.getOne(id);
        msSer.deleteCV(ms);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = msSer.getAll();
        request.setAttribute("listMS", lists);
        request.getRequestDispatcher("/view/mausac/mausacs.jsp").forward(request, response);

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
        MauSac ms = msSer.getData(request.getParameterMap());
        HashMap<String, String> hmString = msSer.addCV(ms);
        request.setAttribute("ms", ms);
        request.setAttribute("sts", hmString);
        lists = msSer.getAll();
        request.setAttribute("listMS", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac ms = msSer.getData(request.getParameterMap());
        ms.setId(id);
        HashMap<String, String> hmString = msSer.updateCV(ms);
        request.setAttribute("ms", ms);
        request.setAttribute("sts", hmString);
        lists = msSer.getAll();
        request.setAttribute("listMS", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}
