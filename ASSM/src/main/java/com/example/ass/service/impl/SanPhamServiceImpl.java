package com.example.ass.service.impl;


import com.example.ass.entity.SanPham;
import com.example.ass.repository.SanPhamRepository;
import com.example.ass.service.SanPhamService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository spRep = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return spRep.getAll();
    }

    @Override
    public SanPham getOne(UUID id) {
        return spRep.getOne(id);
    }

    @Override
    public SanPham getData(Map<String, String[]> spmap) {
        SanPham sanPham = new SanPham();
        try {
            BeanUtils.populate(sanPham, spmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    @Override
    public HashMap<String, String> addSP(SanPham sp) {
        HashMap<String, String> hashMapAdd = validateFm(sp);
//        sp.setMa(genMaKhachHang());
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            spRep.add(sp);
            hashMapAdd.put("url", "/view/sanpham/sanphams.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/sanpham/sanphams.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateSP(SanPham sp) {
        HashMap<String, String> hashMapAdd = validateFm(sp);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            spRep.update(sp);
            hashMapAdd.put("url", "/view/sanpham/sanphams.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/sanpham/view-update.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void deleteSP(SanPham ms) {
        spRep.delete(ms);
    }

//    @Override
//    public String genMaKhachHang() {
//        return "SP"+spRep.genMaKhachHang();
//    }

    private HashMap<String, String> validateFm(SanPham sp) {
        String ma = sp.getMa();
        String ten = sp.getTen();
        HashMap<String, String> hashMapString = new HashMap<>();
        if (ma.trim().isEmpty() || ma == null) {
            hashMapString.put("stsMa", "Mã không được trống");
        }
        if (ma.length() > 20) {
            hashMapString.put("stsMa", "Mã tối đa 20 ký tự");
        }
        if (ten.trim().isEmpty() || ten == null) {
            hashMapString.put("stsTen", "Tên không được trống");
        }
        if (ma.length() > 30) {
            hashMapString.put("stsTen", "Tên tối đa 30 ký tự");
        }
        return hashMapString;
    }
}
