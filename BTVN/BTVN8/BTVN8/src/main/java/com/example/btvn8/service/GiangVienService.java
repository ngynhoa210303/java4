package com.example.btvn8.service;

import com.example.btvn8.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
     List<GiangVien> getAll();
    List<GiangVien>listSearch(String ten, Long tuoiMin, Long tuoiMax);

    GiangVien getOne(String id);
    boolean addGV(GiangVien gv);
    boolean updateGV(GiangVien gv);
    void del(GiangVien gv);
}
