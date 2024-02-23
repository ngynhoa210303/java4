package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.NhanVien;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien getOne(UUID id);

    HashMap<String, String> add(NhanVien nv);

    HashMap<String, String> update(NhanVien nv);

    NhanVien getData(Map<String, String[]> mapNV);

    void delete(NhanVien nv);
}
