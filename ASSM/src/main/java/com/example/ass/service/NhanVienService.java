package com.example.ass.service;

import com.example.ass.entity.NhanVien;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien getOne(UUID id);

    NhanVien getData(Map<String, String[]> cv);

    HashMap<String, String> addNV(NhanVien nv);

    HashMap<String, String> updateNV(NhanVien nv);

    void deleteNV(NhanVien nv);
}
