package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.CTSP;
import com.fpt.poly.lab.service.CTSPService;
import com.fpt.poly.lab.service.impl.CTSPServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CTSPServlet", value = {
        "/ctsp/hien-thi"
})
public class CTSPServlet extends HttpServlet {
    private List<CTSP> list = new ArrayList<>();
    private CTSPService sver = new CTSPServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = sver.getAll();
        request.setAttribute("listCTSP", list);
        request.getRequestDispatcher("/ctsps.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
