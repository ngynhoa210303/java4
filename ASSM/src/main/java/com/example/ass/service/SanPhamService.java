package com.example.ass.service;

import com.example.ass.entity.SanPham;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getOne(UUID id);

    SanPham getData(Map<String, String[]> spmap);

    HashMap<String, String> addSP(SanPham sp);

    HashMap<String, String> updateSP(SanPham sp);

    void deleteSP(SanPham ms);

//    public String genMaKhachHang();
}
