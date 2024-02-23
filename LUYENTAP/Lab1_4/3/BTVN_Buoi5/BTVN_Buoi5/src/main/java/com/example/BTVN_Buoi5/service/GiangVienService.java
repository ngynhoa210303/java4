package com.example.BTVN_Buoi5.service;

import com.example.BTVN_Buoi5.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien> fakeData();

    void removeGV(List<GiangVien> listGV, int index);

    boolean addGV(List<GiangVien> listGV, GiangVien gv);

    boolean updateGV(List<GiangVien> listGV, int index, GiangVien gv);

    List<GiangVien> searchGV(List<GiangVien> listGV, String tenSearch, String min, String max);

    int getIndexByMaGV(List<GiangVien> listGV, String maGV);
}
