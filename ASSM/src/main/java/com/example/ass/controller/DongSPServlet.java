package com.example.ass.controller;

import com.example.ass.entity.DongSP;
import com.example.ass.service.DongSPService;
import com.example.ass.service.impl.DongSPServiceImpl;
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

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi-tat-ca",
        "/dong-sp/remove",
        "/dong-sp/add",
        "/dong-sp/detail",
        "/dong-sp/update",
        "/dong-sp/view-update",
})
public class DongSPServlet extends HttpServlet {
    private List<DongSP> lists = new ArrayList<>();
    private DongSPService dongSPService = new DongSPServiceImpl();
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
        DongSP dsp = dongSPService.getOne(id);
        request.setAttribute("dsp", dsp);
        request.getRequestDispatcher("/view/dongsp/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        DongSP dsp = dongSPService.getOne(id);
        request.setAttribute("dsp", dsp);
        this.hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        DongSP dsp = dongSPService.getOne(id);
        request.setAttribute("dsp", dsp);
        dongSPService.deleteCV(dsp);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = dongSPService.getAll();
        request.setAttribute("listDSP", lists);
        request.getRequestDispatcher("/view/dongsp/dongsps.jsp").forward(request, response);
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
        DongSP dsp = dongSPService.getData(request.getParameterMap());
        HashMap<String, String> hmString = dongSPService.addCV(dsp);
        request.setAttribute("mess", hmString.get("mess"));
        request.setAttribute("dsp", dsp);
        request.setAttribute("sts", hmString);
        this.hienThi(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSP dsp = dongSPService.getData(request.getParameterMap());
        dsp.setId(id);
        HashMap<String, String> hmString = dongSPService.updateCV(dsp);
        request.setAttribute("sts", hmString);
        lists = dongSPService.getAll();
        request.setAttribute("listDSP", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}
