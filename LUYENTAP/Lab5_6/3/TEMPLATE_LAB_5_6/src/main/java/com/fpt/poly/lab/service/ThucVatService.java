package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.ThucVat;

import java.util.List;

public interface ThucVatService {
    List<ThucVat> getAll();

    ThucVat getOne(Long id);

    String add(ThucVat tv);

    String update(ThucVat tv);

    String delete(ThucVat tv);
    List<ThucVat> listSearch(String ten,Integer tuoiMin,Integer tuoiMax);
}
