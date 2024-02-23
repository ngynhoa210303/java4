package com.example.btvn8.service.impl;

import com.example.btvn8.entity.GiangVien;
import com.example.btvn8.repository.IGiangVienRepository;
import com.example.btvn8.repository.impl.GiangVienRepository;
import com.example.btvn8.service.GiangVienService;

import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    IGiangVienRepository gvRep = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return gvRep.getAll();
    }

    @Override
    public List<GiangVien> listSearch(String ten, Long tuoiMin, Long tuoiMax) {
        return gvRep.listSearch(ten, tuoiMin, tuoiMax);
    }

    @Override
    public GiangVien getOne(String id) {
        return gvRep.getOne(id);
    }

    @Override
    public boolean addGV(GiangVien gv) {
        return gvRep.addGV(gv);
    }

    @Override
    public boolean updateGV(GiangVien gv) {
        return gvRep.updateGV(gv);
    }

    @Override
    public void del(GiangVien gv) {
        gvRep.delGV(gv);
    }
}
