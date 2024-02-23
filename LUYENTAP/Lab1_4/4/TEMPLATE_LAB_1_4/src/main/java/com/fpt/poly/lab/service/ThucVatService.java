package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.ThucVat;

import java.util.List;

public interface ThucVatService {
    List<ThucVat> listData();

    boolean addTV(List<ThucVat> lists, ThucVat tv);

    boolean updateTV(List<ThucVat> lists, int index, ThucVat tv);

    ThucVat getOne(List<ThucVat> lists, int index);

    void remove(List<ThucVat> lists, int index);

    List<ThucVat> search(List<ThucVat> lists, String tenSearch, String min, String max);
}
