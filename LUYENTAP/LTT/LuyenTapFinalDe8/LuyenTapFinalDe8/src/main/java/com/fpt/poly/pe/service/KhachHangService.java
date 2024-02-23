package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.KhachHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(String ten);

    KhachHang getData(Map<String, String[]> stringMap);

    HashMap<String, String> add(KhachHang khachHang);

    HashMap<String, String> update(KhachHang khachHang);

    void delete(KhachHang khachHang);
}
