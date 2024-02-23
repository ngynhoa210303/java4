package com.example.ass.controller;

import com.example.ass.entity.ChiTietSP;
import com.example.ass.entity.DongSP;
import com.example.ass.entity.MauSac;
import com.example.ass.entity.NhaSanXuat;
import com.example.ass.entity.SanPham;
import com.example.ass.service.ChiTietSPService;
import com.example.ass.service.DongSPService;
import com.example.ass.service.MauSacService;
import com.example.ass.service.NhaSanXuatService;
import com.example.ass.service.SanPhamService;
import com.example.ass.service.impl.ChiTietSPServiceImpl;
import com.example.ass.service.impl.DongSPServiceImpl;
import com.example.ass.service.impl.MauSacServiceImpl;
import com.example.ass.service.impl.NhaSanXuatServiceImpl;
import com.example.ass.service.impl.SanPhamServiceImpl;
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

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-sp/hien-thi-tat-ca",
        "/chi-tiet-sp/remove",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/view-update",
})
public class ChiTietSPServlet extends HttpServlet {
    private List<ChiTietSP> lists = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<MauSac> listMS = new ArrayList<>();
    private List<DongSP> listDongSP = new ArrayList<>();
    private List<NhaSanXuat> listNSX = new ArrayList<>();
    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImpl();
    private MauSacService msService = new MauSacServiceImpl();
    private NhaSanXuatService nsxService = new NhaSanXuatServiceImpl();
    private DongSPService dspService = new DongSPServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
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
    private void setLists(HttpServletRequest request){
        lists = chiTietSPService.getAll();
        request.setAttribute("lists", lists);
        listSanPham = sanPhamService.getAll();
        request.setAttribute("listSP", listSanPham);
        listNSX = nsxService.getAll();
        request.setAttribute("listNSX", listNSX);
        listMS = msService.getAll();
        request.setAttribute("listMS", listMS);
        listDongSP = dspService.getAll();
        request.setAttribute("listDSP", listDongSP);
    }
    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        ChiTietSP chiTietSanPham = chiTietSPService.getOne(id);
        SanPham sanPham = chiTietSanPham.getIdSP();
        NhaSanXuat nsx = chiTietSanPham.getIdNSX();
        DongSP dongSP = chiTietSanPham.getIdDongSP();
        this.setLists(request);
        request.setAttribute("detail", chiTietSanPham);
        request.setAttribute("sanPham", sanPham);
        request.setAttribute("dongSP", dongSP);
        request.setAttribute("nsx", nsx);
        request.getRequestDispatcher("/view/chitietsp/view-update.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        ChiTietSP chiTietSanPham = chiTietSPService.getOne(id);
        request.setAttribute("detail", chiTietSanPham);
        this.hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = UUID.fromString(request.getParameter("id"));
        ChiTietSP chiTietSanPham = chiTietSPService.getOne(id);
        chiTietSPService.delete(chiTietSanPham);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setLists(request);
        request.getRequestDispatcher("/view/chitietsp/chitietsps.jsp").forward(request, response);
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
        ChiTietSP ctsp = chiTietSPService.getData(request.getParameterMap());
        HashMap<String, String> hmString = chiTietSPService.addCTSP(ctsp);
        request.setAttribute("detail", ctsp);
        request.setAttribute("sts", hmString);
        this.setLists(request);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP ctsp = chiTietSPService.getData(request.getParameterMap());
        ctsp.setId(id);
        SanPham sp = ctsp.getIdSP();
        request.setAttribute("sanPham", sp);
        HashMap<String, String> hmString = chiTietSPService.updateCTSP(ctsp);
        request.setAttribute("detail", ctsp);
        request.setAttribute("sts", hmString);
        this.setLists(request);
        request.setAttribute("mess", hmString.get("mess"));
        request.getRequestDispatcher(hmString.get("url")).forward(request, response);
    }
}
