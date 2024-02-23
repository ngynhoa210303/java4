package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.DongVat;
import com.fpt.poly.lab.repository.DongVatRepository;
import com.fpt.poly.lab.service.DongVatService;

import java.util.List;
import java.util.UUID;

public class DongVatServiceImpl implements DongVatService {
    DongVatRepository dvRep = new DongVatRepository();

    @Override
    public List<DongVat> getAll() {
        return dvRep.getAll();
    }

    @Override
    public DongVat getOne(UUID id) {
        return dvRep.getOne(id);
    }

    @Override
    public String add(DongVat dv) {
        if (dv.getTen().isEmpty() || dv.getTuoi().toString().isEmpty() || dv.getKhuVucSong().isEmpty()) {
            return "Thông tin còn thiếu";
        } else {
            dvRep.add(dv);
            return "Thêm thành công";
        }
    }

    @Override
    public String update(DongVat dv) {
        if (dv.getTen().isEmpty() || dv.getTuoi().toString().isEmpty() || dv.getKhuVucSong().isEmpty()) {
            return "Thông tin còn thiếu";
        } else {
            dvRep.update(dv);
            return "Sửa thành công";
        }
    }


    @Override
    public String delete(DongVat mt) {
        if (dvRep.delete(mt)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

//    @Override
//    public List<MayTinh> searchGiamTheoGiaHoacHangBangCBB(String orderBy) {
//        return mtRep.searchGiamTheoGiaHoacHangBangCBB(orderBy);
//    }
}
