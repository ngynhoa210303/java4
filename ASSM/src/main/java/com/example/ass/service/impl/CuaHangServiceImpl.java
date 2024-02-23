package com.example.ass.service.impl;

import com.example.ass.entity.CuaHang;
import com.example.ass.repository.CuaHangRepository;
import com.example.ass.service.CuaHangService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository chRep = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return chRep.getAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return chRep.getOne(id);
    }

    @Override
    public CuaHang getData(Map<String, String[]> chMap) {
        CuaHang ch = new CuaHang();
        try {
            BeanUtils.populate(ch, chMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    @Override
    public HashMap<String, String> add(CuaHang ch) {
        HashMap<String, String> hashMapAdd = validate(ch);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            chRep.add(ch);
            hashMapAdd.put("url", "/view/cuahang/cuahangs.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/cuahang/cuahangs.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> update(CuaHang ch) {
        HashMap<String, String> hashMapAdd = validate(ch);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            chRep.update(ch);
            hashMapAdd.put("url", "/view/cuahang/cuahangs.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/cuahang/view-update.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void delete(CuaHang ch) {
        chRep.delete(ch);
    }

    private HashMap<String, String> validate(CuaHang ch) {
        HashMap<String, String> hashMapStr = new HashMap<>();
        if (ch.getMa().trim().isEmpty() || ch.getMa() == null) {
            hashMapStr.put("stsMa", "Mã không thể để trống");
        }
        if (ch.getMa().length() > 20) {
            hashMapStr.put("stsMa", "Mã không thể vượt quá 20 ký tự");
        }
        if (ch.getTen().trim().isEmpty() || ch.getTen() == null) {
            hashMapStr.put("stsTen", "Tên không thể để trống");
        }
        if (ch.getMa().length() > 50) {
            hashMapStr.put("stsTen", "Tên không thể vượt quá 50 ký tự");
        }
        if (ch.getDiaChi().trim().isEmpty() || ch.getDiaChi() == null) {
            hashMapStr.put("stsDiaChi", "Địa chỉ không thể để trống");
        }
        if (ch.getDiaChi().length() > 100) {
            hashMapStr.put("stsDiaChi", "Địa chỉ không thể vượt quá 100 ký tự");
        }
        if (ch.getThanhPho().trim().isEmpty() || ch.getThanhPho() == null) {
            hashMapStr.put("stsThanhPho", "Thành phố không thể để trống");
        }
        if (ch.getQuocGia().trim().isEmpty() || ch.getThanhPho() == null) {
            hashMapStr.put("stsQuocGia", "Quốc gia không thể để trống");
        }
        if (ch.getQuocGia().length() > 50) {
            hashMapStr.put("stsQuocGia", "Tên quốc gia không vượt quá 50 ký tự");
        }
        return hashMapStr;
    }
}
