package com.fpt.poly.lab.controller;

import com.fpt.poly.lab.entity.MayTinh;
import com.fpt.poly.lab.service.MaySinhService;
import com.fpt.poly.lab.service.impl.MayTinhServiceImpl;
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

@WebServlet(name = "MayTinhServlet", value = {
        "",
        "/may-tinh/hien-thi",
        "/may-tinh/detai",
        "/may-tinh/remove",
        "/may-tinh/view-add",
        "/may-tinh/view-update",
        "/may-tinh/add",
        "/may-tinh/update",
        "/may-tinh/sap-xep",
})
public class MayTinhServlet extends HttpServlet {
    private final MaySinhService maySinhService = new MayTinhServiceImpl();
    private List<MayTinh> mayTinhs = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiMayTinh(request, response);
        } else if (uri.contains("detai")) {
            this.detaiMayTinh(request, response);
        } else if (uri.contains("remove")) {
            this.removeMayTinh(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddMayTinh(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateMayTinh(request, response);
        } else if (uri.contains("sap-xep")) {
            this.sapXepMayTinh(request, response);
        } else {
            response.sendRedirect("/may-tinh/hien-thi");
        }
    }

    private void sapXepMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sapXep = request.getParameter("sapXep");
        mayTinhs = maySinhService.getMayTinhListSort(sapXep);
        request.setAttribute("mayTinhs", mayTinhs);
        request.setAttribute("sapXep", sapXep);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void viewUpdateMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = maySinhService.getMayTinh(ma);
        request.setAttribute("mayTinh", mayTinh);
        request.getRequestDispatcher("/update-may-tinh.jsp").forward(request, response);
    }

    private void viewAddMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-may-tinh.jsp").forward(request, response);
    }

    private void removeMayTinh(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = maySinhService.getMayTinh(ma);
        maySinhService.removeMayTinh(mayTinh);
        mayTinhs = maySinhService.getMayTinhList();
        request.setAttribute("mayTinhs", mayTinhs);
        request.setAttribute("mess", "Xóa máy tính thành công");
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void detaiMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("ma"));
        MayTinh mayTinh = maySinhService.getMayTinh(ma);
        request.setAttribute("mayTinh", mayTinh);
        request.getRequestDispatcher("/detail-may-tinh.jsp").forward(request, response);
    }

    private void hienThiMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mayTinhs = maySinhService.getMayTinhList();
        request.setAttribute("mayTinhs", mayTinhs);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addMayTinh(request, response);
        } else if (uri.contains("update")) {
            this.updateMayTinh(request, response);
        } else {
            response.sendRedirect("/may-tinh/hien-thi");
        }
    }

    private void updateMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID ma = UUID.fromString(request.getParameter("maMay"));
        MayTinh mayTinh = maySinhService.getDataFrom(request.getParameterMap());
        mayTinh.setMa(ma);
        HashMap<String, String> stringHashMap = maySinhService.updateMayTinh(mayTinh);
        request.setAttribute("mayTinh", mayTinh);
        request.setAttribute("err", stringHashMap);
        mayTinhs = maySinhService.getMayTinhList();
        request.setAttribute("mayTinhs", mayTinhs);
        request.setAttribute("mess", stringHashMap.get("mess"));
        request.getRequestDispatcher(stringHashMap.get("url")).forward(request, response);
    }

    private void addMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MayTinh mayTinh = maySinhService.getDataFrom(request.getParameterMap());
        HashMap<String, String> stringHashMap = maySinhService.addMayTinh(mayTinh);
        request.setAttribute("mayTinh", mayTinh);
        request.setAttribute("err", stringHashMap);
        mayTinhs = maySinhService.getMayTinhList();
        request.setAttribute("mayTinhs", mayTinhs);
        request.setAttribute("mess", stringHashMap.get("mess"));
        request.getRequestDispatcher(stringHashMap.get("url")).forward(request, response);
    }
}
