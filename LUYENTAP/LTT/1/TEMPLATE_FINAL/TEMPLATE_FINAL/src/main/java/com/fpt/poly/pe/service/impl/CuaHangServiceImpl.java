package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.CuaHang;
import com.fpt.poly.pe.repository.CuaHangRepository;
import com.fpt.poly.pe.service.CuaHangService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository chRep = new CuaHangRepository();
    private List<CuaHang> list = new ArrayList<>();
    private int liss = list.size();

    @Override
    public List<CuaHang> getAll() {
        return chRep.getAll();
    }

    @Override
    public CuaHang getOne(String id) {
        return chRep.getOne(id);
    }

    @Override
    public void delete(CuaHang ch) {
        chRep.delete(ch);
    }

    @Override
    public CuaHang getData(Map<String, String[]> chMap) {
        CuaHang ch = new CuaHang();
        try {
            ch.setDiaChi(chMap.get("diaChi")[0]);
            ch.setTen(chMap.get("ten")[0]);
            ch.setThanhPho(chMap.get("thanhPho")[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    @Override
    public HashMap<String, String> add(CuaHang ch) {
        HashMap<String, String> hs = validate(ch);

        if (hs.isEmpty()) {
            if (chRep.checkTrung(ch.getMa())) {
                hs.put("stsMa", "Mã trung");
                hs.put("mess", "Add that bai");
            }
            ch.setMa("CH"+(++liss));
            hs.put("mess", "Add thanh cong");
            chRep.add(ch);
        } else {
            hs.put("mess", "Add that bai");
        }
        return hs;
    }

    @Override
    public HashMap<String, String> update(CuaHang ch) {
        HashMap<String, String> hs = validate(ch);
        if (hs.isEmpty()) {
            hs.put("mess", "Update thanh cong");
            chRep.update(ch);
        } else {
            hs.put("mess", "Update that bai");
        }
        return hs;
    }

    private HashMap<String, String> validate(CuaHang ch) {
        HashMap<String, String> hm = new HashMap<>();
        if (ch.getMa().trim().isEmpty()) {
            hm.put("stsMa", "Ma trong");
        }
        if (ch.getTen().trim().isEmpty()) {
            hm.put("stsTen", "Ten trong");
        }
        if (ch.getDiaChi().trim().isEmpty()) {
            hm.put("stsDiaChi", "Dia Chi trong");
        }
        return hm;
    }

}
