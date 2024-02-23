package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SinhVien;

import java.util.List;
import java.util.UUID;

public interface SinhVienService {
    List<SinhVien> getAll();

    SinhVien getOne(UUID id);

    String addSV(SinhVien sv);

    String updateSV(SinhVien sv);

    String deleteSV(SinhVien sv);

//    List<SinhVien> listSearch(String ten);

    List<SinhVien> listSearch2DK(String ten, Boolean gioiTinh);
}
