package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    String add(SanPham sp);
    String update(SanPham sp);
    String delete(SanPham sp);
    SanPham getOne(Long id);
    List<SanPham> search(String ten);
}
