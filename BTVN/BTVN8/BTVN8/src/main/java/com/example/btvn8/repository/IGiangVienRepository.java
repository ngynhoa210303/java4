package com.example.btvn8.repository;

import com.example.btvn8.entity.GiangVien;
import com.example.btvn8.service.GiangVienService;

import java.util.List;

public interface IGiangVienRepository {
    List<GiangVien> getAll();

    GiangVien getOne(String id);

    Boolean addGV(GiangVien gv);
    Boolean updateGV(GiangVien gv);
    Boolean delGV(GiangVien gv);

    List<GiangVien>listSearch(String ten,Long tuoiMin,Long tuoiMax);
}
