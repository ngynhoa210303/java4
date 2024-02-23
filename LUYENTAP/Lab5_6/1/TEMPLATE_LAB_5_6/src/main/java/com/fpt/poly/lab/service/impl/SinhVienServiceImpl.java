package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.repository.SinhVienRepository;
import com.fpt.poly.lab.repository.impl.SinhVienRepositoryImpl;
import com.fpt.poly.lab.service.SinhVienService;

import java.util.List;
import java.util.UUID;

public class SinhVienServiceImpl implements SinhVienService {

    SinhVienRepository svRep = new SinhVienRepositoryImpl();

    @Override
    public List<SinhVien> getAll() {
        return svRep.getAll();
    }

    @Override
    public SinhVien getOne(UUID id) {
        return svRep.getOne(id);
    }

    @Override
    public String addSV(SinhVien sv) {
        if (svRep.addSV(sv)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String updateSV(SinhVien sv) {
        if (svRep.updateSV(sv)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String deleteSV(SinhVien sv) {
        if (svRep.removeSV(sv)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

//    @Override
//    public List<SinhVien> listSearch(String ten) {
//        return svRep.listSearch(ten);
//    }

    @Override
    public List<SinhVien> listSearch2DK(String ten, Boolean gioiTinh) {
        return svRep.listSearch2DK(ten, gioiTinh);
    }
}
