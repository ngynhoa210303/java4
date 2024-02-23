package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.ThucVat;
import com.fpt.poly.lab.repository.ThucVatRepository;
import com.fpt.poly.lab.service.ThucVatService;

import java.util.List;

public class ThucVatServiceImpl implements ThucVatService {
    ThucVatRepository tvRep = new ThucVatRepository();

    @Override
    public List<ThucVat> getAll() {
        return tvRep.getAll();
    }

    @Override
    public ThucVat getOne(Long id) {
        return tvRep.getOne(id);
    }

    @Override
    public String add(ThucVat tv) {
        if(tv.getTen().trim().isEmpty()||tv.getKhuVuc().trim().isEmpty()||tv.getTuoi().toString().isEmpty()){
            return "Thông tin còn trống";
        }
        else {
            tvRep.add(tv);
            return "Thêm thành công";
        }

    }

    @Override
    public String update(ThucVat tv) {
        if(tv.getTen().trim().isEmpty()||tv.getKhuVuc().trim().isEmpty()||tv.getTuoi().toString().isEmpty()){
            return "Thông tin còn trống";
        }
        else {
            tvRep.update(tv);
            return "Sửa thành công";
        }
    }

    @Override
    public String delete(ThucVat tv) {
        if(tvRep.delete(tv)){
            return "Xóa thành công";
        }else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<ThucVat> listSearch(String ten, Integer tuoiMin, Integer tuoiMax) {
        return tvRep.listSearch(ten, tuoiMin, tuoiMax);
    }
}
