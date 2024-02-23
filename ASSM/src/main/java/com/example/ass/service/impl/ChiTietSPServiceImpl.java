package com.example.ass.service.impl;

import com.example.ass.entity.ChiTietSP;
import com.example.ass.entity.DongSP;
import com.example.ass.entity.MauSac;
import com.example.ass.entity.NhaSanXuat;
import com.example.ass.entity.SanPham;
import com.example.ass.repository.ChiTietSPRepository;
import com.example.ass.service.ChiTietSPService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ChiTietSPServiceImpl implements ChiTietSPService {
    ChiTietSPRepository ctRep = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return ctRep.getAll();
    }

    @Override
    public ChiTietSP getOne(UUID id) {
        return ctRep.getOne(id);
    }

    @Override
    public void delete(ChiTietSP ctsp) {
        ctRep.delete(ctsp);
    }

    @Override
    public ChiTietSP getData(Map<String, String[]> khmap) {
        ChiTietSP ctsp = new ChiTietSP();
        try {
            UUID sanPham = UUID.fromString(khmap.get("sanPham")[0]);
            UUID mauSac = UUID.fromString(khmap.get("mauSac")[0]);
            UUID dongSP = UUID.fromString(khmap.get("dongSP")[0]);
            UUID nsx = UUID.fromString(khmap.get("nsx")[0]);
            BigDecimal gbBig = khmap.get("giaBan") != null ? new BigDecimal(khmap.get("giaBan")[0]) : null;
            BigDecimal gnBig = khmap.get("giaNhap") != null ? new BigDecimal(khmap.get("giaNhap")[0]) : null;
            ctsp.setIdNSX(new NhaSanXuat(nsx));
            ctsp.setIdDongSP(new DongSP(dongSP));
            ctsp.setIdMauSac(new MauSac(mauSac));
            ctsp.setIdSP(new SanPham(sanPham));
            ctsp.setGiaBan(gbBig);
            ctsp.setGiaNhap(gnBig);
            ctsp.setNamBH(Integer.parseInt(khmap.get("namBH")[0]));
            ctsp.setSoLuongTon(Integer.parseInt(khmap.get("soLuongTon")[0]));
            ctsp.setMoTa(khmap.get("moTa")[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    @Override
    public HashMap<String, String> addCTSP(ChiTietSP chiTietSP) {
        HashMap<String, String> hashMapAdd = validateForm(chiTietSP);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            ctRep.add(chiTietSP);
            hashMapAdd.put("url", "/view/chitietsp/chitietsps.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/chitietsp/chitietsps.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateCTSP(ChiTietSP chiTietSP) {
        HashMap<String, String> hashMapAdd = validateForm(chiTietSP);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            ctRep.update(chiTietSP);
            hashMapAdd.put("url", "/view/chitietsp/chitietsps.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/chitietsp/view-update.jsp");
        }
        return hashMapAdd;
    }

    private HashMap<String, String> validateForm(ChiTietSP ctsp) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (ctsp.getSoLuongTon() == null) {
            ctsp.setSoLuongTon(0);
        }
        if (ctsp.getSoLuongTon() == 0) {
            hashMap.put("stsSLT", "Phải điền số lượng tồn (là số)");
        }
        if (ctsp.getSoLuongTon() < 0) {
            hashMap.put("stsSLT", "Số lượng tồn phải là số >0");
        }
        if (ctsp.getNamBH() == null) {
            ctsp.setNamBH(0);
        }
        if (ctsp.getNamBH() < 0) {
            hashMap.put("stsNBH", "Năm bảo hành phải là số >0");
        }
        if (ctsp.getNamBH() == 0) {
            hashMap.put("stsNBH", "Phải điền năm bảo hành (là số)");
        }

        if (ctsp.getGiaNhap() == null) {
            ctsp.setGiaNhap(new BigDecimal(0));
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) < 0) {
            // giaNhap âm
            hashMap.put("stsNhap", "Gia nhập phải là số >0");
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) == 0) {
            // giaNhap âm
            hashMap.put("stsNhap", "Phải điền giá nhập (là số)");
        }
        if (ctsp.getGiaBan() == null) {
            ctsp.setGiaBan(new BigDecimal(0));
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) <= 0) {
            // giaNhap âm
            hashMap.put("stsBan", "Gia bán phải là số >0");
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) == 0) {
            // giaNhap âm
            hashMap.put("stsBan", "Phải điền giá nhập (là số)");
        }
        return hashMap;
    }


}
