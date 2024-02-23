package com.example.ass.service;

import com.example.ass.entity.KhachHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(UUID id);
    String genMaKH();

    KhachHang getData(Map<String, String[]> khmap,boolean createNew,String ma);

    HashMap<String, String> addKH(KhachHang kh);

    HashMap<String, String> updateKH(KhachHang kh);

    void delKH(KhachHang kh);
}
