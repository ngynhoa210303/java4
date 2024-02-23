package com.example.btvn9.service;

import com.example.btvn9.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
     List<GiangVien> getAll();
    List<GiangVien>listSearch(String ten, Long tuoiMin, Long tuoiMax);

    GiangVien getOne(Long id);
    String addGV(GiangVien gv);
    boolean updateGV(GiangVien gv);
    void del(GiangVien gv);
    List<GiangVien> listNu();
}
