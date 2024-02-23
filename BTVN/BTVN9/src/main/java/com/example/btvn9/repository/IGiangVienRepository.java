package com.example.btvn9.repository;

import com.example.btvn9.entity.GiangVien;

import java.util.List;

public interface IGiangVienRepository {
    List<GiangVien> getAll();

    GiangVien getOne(Long id);

    Boolean addGV(GiangVien gv);
    Boolean updateGV(GiangVien gv);
    Boolean delGV(GiangVien gv);

    List<GiangVien>listSearch(String ten,Long tuoiMin,Long tuoiMax);
    List<GiangVien>listNu();
}
