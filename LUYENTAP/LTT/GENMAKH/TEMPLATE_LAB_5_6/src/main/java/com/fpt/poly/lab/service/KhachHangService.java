package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.request.KhachHangRequest;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();
    KhachHang getOne(UUID id);
     HashMap<String, String> add(KhachHangRequest request);
     HashMap<String, String> update(KhachHangRequest request, UUID id);
    boolean delete(UUID id);
    List<KhachHang> search(String ten);
    int genMaKhachHang();
}
