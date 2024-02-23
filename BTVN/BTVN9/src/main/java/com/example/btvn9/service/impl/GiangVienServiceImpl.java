package com.example.btvn9.service.impl;

import com.example.btvn9.entity.GiangVien;
import com.example.btvn9.repository.IGiangVienRepository;
import com.example.btvn9.repository.impl.GiangVienRepository;
import com.example.btvn9.service.GiangVienService;

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
    public GiangVien getOne(Long id) {
        return gvRep.getOne(id);
    }

    @Override
    public String addGV(GiangVien gv) {
        if (gv.getMa().isEmpty() || gv.getDiaChi().isEmpty() || gv.getTen().isEmpty() || String.valueOf(gv.getTuoi()).isEmpty()) {
            return "Thiếu thông tin";
        } else {
            gvRep.addGV(gv);
            return "Thêm thành công";
        }

    }

    @Override
    public boolean updateGV(GiangVien gv) {
        return gvRep.updateGV(gv);
    }

    @Override
    public void del(GiangVien gv) {
        gvRep.delGV(gv);
    }

    @Override
    public List<GiangVien> listNu() {
        return gvRep.listNu();
    }
}
