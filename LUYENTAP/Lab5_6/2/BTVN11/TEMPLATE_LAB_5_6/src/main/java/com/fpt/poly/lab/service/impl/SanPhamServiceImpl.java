package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.repository.SanPhamRepository;
import com.fpt.poly.lab.service.SanPhamService;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
  SanPhamRepository spRep=new SanPhamRepository();
    @Override
    public List<SanPham> getAll() {
        return spRep.getAll();
    }

    @Override
    public String add(SanPham sp) {
//        Boolean
        if(sp.getMa().trim().isEmpty()||sp.getTen().trim().isEmpty()||Float.isNaN(sp.getGia())){
            return "Thông tin không được trống";
        }
        else {
            spRep.add(sp);
            return "Thêm thành công";
        }
    }

    @Override
    public String update(SanPham sp) {
        Boolean update=spRep.update(sp);
        if (update){
            return "Sửa thành công";
        }else {
            return "Sửa Thất bại";
        }
    }

    @Override
    public String delete(SanPham sp) {
        Boolean del=spRep.delete(sp);
        if (del){
            return "Xóa thành công";
        }else {
            return "Xóa Thất bại";
        }
    }

    @Override
    public SanPham getOne(Long id) {
        return spRep.getOne(id);
    }

    @Override
    public List<SanPham> search(String ten) {
        return spRep.search(ten);
    }
}
