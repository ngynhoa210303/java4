package com.example.ass.controller;

import com.example.ass.entity.ChucVu;
import com.example.ass.service.ChucVuService;
import com.example.ass.service.impl.ChucVuServiceImpl;
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

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi-tat-ca",
        "/chuc-vu/remove",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/view-update",
})
public class ChucVuServlet extends HttpServlet {
    private List<ChucVu> lists = new ArrayList<>();
    private ChucVuService cvSer = new ChucVuServiceImpl();
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
        ChucVu cv = cvSer.getOne(id);
        request.setAttribute("cv", cv);
        request.getRequestDispatcher("/view/chucvu/view-update-cvu.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        ChucVu cv = cvSer.getOne(id);
        request.setAttribute("cv", cv);
        this.hienThi(request,response);

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        ChucVu cv = cvSer.getOne(id);
        cvSer.deleteCV(cv);
        request.setAttribute("mess", "Xóa thành công");
        this.hienThi(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = cvSer.getAll();
        request.setAttribute("listCV", lists);
        request.getRequestDispatcher("/view/chucvu/chucvus.jsp").forward(request, response);
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
        ChucVu cv = cvSer.getData(request.getParameterMap());
        HashMap<String, String> hmString = cvSer.addCV(cv);
        request.setAttribute("cv", cv);
        request.setAttribute("sts", hmString);
        lists = cvSer.getAll();
        request.setAttribute("listCV", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        id = UUID.fromString(request.getParameter("id"));
        ChucVu cv = cvSer.getData(request.getParameterMap());
        cv.setId(id);
        HashMap<String, String> hmString = cvSer.updateCV(cv);
//        request.setAttribute("cv", cv);
        request.setAttribute("sts", hmString);
        lists = cvSer.getAll();
        request.setAttribute("listCV", lists);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}