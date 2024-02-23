package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien>fakeData();
    void removeGiangVien(List<GiangVien>lists,String id);
    GiangVien findGiangVienByID(List<GiangVien>lists,String id);

    List<GiangVien>listSearch(List<GiangVien>lists,String ten);
    List<GiangVien>listNu(List<GiangVien>lists,Boolean gioiTinh);

    boolean updateGV(String id, List<GiangVien> lists, GiangVien giangVien);

    GiangVien getOne(List<GiangVien>list,int index);
    void removeGV(List<GiangVien>lists,int index);
}
