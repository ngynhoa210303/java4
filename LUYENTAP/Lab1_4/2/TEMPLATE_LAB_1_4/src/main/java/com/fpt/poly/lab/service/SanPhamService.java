package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.SanPham;

import javax.swing.*;
import java.util.List;

public interface SanPhamService {
    List<SanPham> listFake();

    SanPham getOneSP(List<SanPham> lists, int index);

    boolean addSP(List<SanPham> lists, SanPham sp);

    boolean updateSP(List<SanPham> lists, int index, SanPham sp);
    int getIndexByID(List<SanPham> lists, String id);
//    SanPham findSPByID(List<SanPham> lists, String id);
    SanPham removeSP(List<SanPham>lists,int index );

    List<SanPham>listSearch(List<SanPham>lists,String ten);
}
