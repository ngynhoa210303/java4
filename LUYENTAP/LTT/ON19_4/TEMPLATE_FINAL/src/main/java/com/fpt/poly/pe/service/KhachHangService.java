package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.KhachHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    HashMap<String, String> add(KhachHang kh);

    KhachHang getData(Map<String, String[]> hsm);

    void delete(KhachHang kh);
}
