package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    @Override
    public List<SanPham> listFake() {
        List<SanPham> list = new ArrayList<>();
        list.add(new SanPham(1, "HangNT169", "Táo", "3", 2000));
        list.add(new SanPham(2, "HangNT169", "Táo", "1", 200));
        list.add(new SanPham(3, "HangNT169", "Táo", "2", 2000));
        list.add(new SanPham(4, "HangNT169", "Táo", "3", 4000));
        list.add(new SanPham(5, "HangNT169", "Táo", "1", 6000));
        list.add(new SanPham(6, "HangNT169", "Táo", "3", 8000));
        return list;
    }

    @Override
    public SanPham getOneSP(List<SanPham> lists, int index) {
        return lists.get(index);
    }

    @Override
    public boolean addSP(List<SanPham> lists, SanPham sp) {
        boolean add = false;
        if (sp.getMa().isEmpty() || sp.getTen().isEmpty()) {
            return add;
        } else if (!String.valueOf(sp.getGia()).matches("[0-9]+") || sp.getGia() < 150) {
            return add;
        } else {
            lists.add(sp);
            add = true;
            return add;
        }
    }

    @Override
    public boolean updateSP(List<SanPham> lists, int index, SanPham sp) {
        boolean update = false;
        if (sp.getMa().isEmpty() || sp.getTen().isEmpty()) {
            return update;
        } else if (!String.valueOf(sp.getGia()).matches("[0-9]+") || sp.getGia() < 150) {
            return update;
        } else {
            lists.set(index, sp);
            update = true;
            return update;
        }
    }

    @Override
    public int getIndexByID(List<SanPham> lists, String id) {
        int index = -2;
        for (int i = 0; i < lists.size(); i++) {
            if (String.valueOf(lists.get(i).getId()).equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public SanPham removeSP(List<SanPham> lists, int index) {
        return lists.remove(index);
    }

    @Override
    public List<SanPham> listSearch(List<SanPham> lists, String ten) {
        List<SanPham> listSearch = new ArrayList<>();
        for (SanPham x : lists) {
            if (x.getTen().contains(ten)) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

//    @Override
//    public SanPham findSPByID(List<SanPham> lists, String id) {
//        int viTriTimDc=getIndexByID(lists, id);
//        return lists.get(viTriTimDc);
//    }
}
