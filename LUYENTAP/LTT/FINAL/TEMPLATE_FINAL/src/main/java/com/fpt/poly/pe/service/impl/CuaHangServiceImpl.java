package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.CuaHang;
import com.fpt.poly.pe.repository.CuaHangRepository;
import com.fpt.poly.pe.service.CuaHangService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository chRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return chRepository.getAll();
    }

    @Override
    public CuaHang getOne(UUID ma) {
        return chRepository.getOne(ma);
    }

    @Override
    public CuaHang getData(Map<String, String[]> chmap) {
        CuaHang ch = new CuaHang();
        try {
            ch.setMa(genMa());
            ch.setTen(chmap.get("ten")[0]);
            ch.setThanhPho(chmap.get("thanhPho")[0]);
            ch.setDiaChi(chmap.get("diaChi")[0]);
            ch.setQuocGia(chmap.get("quocGia")[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    @Override
    public HashMap<String, String> addCH(CuaHang ch) {

        HashMap<String, String> hashMap = validate(ch);
        if (hashMap.isEmpty()) {
            hashMap.put("mess", "Add thành công");
            chRepository.addCH(ch);
        } else {
            hashMap.put("mess", "Add thất bại");
        }
        return hashMap;
    }

    @Override
    public void delete(CuaHang ch) {
        chRepository.deleteCH(ch);
    }

    private String genMa() {
        String maGen = "";
        Random random = new Random();
        for (int i = 0; i <= 3; i++) {
            maGen += (char) (random.nextInt(26) + 'a');
        }
        for (int i = 0; i <= 2; i++) {
            maGen += (char) (random.nextInt(26) + 'A');
        }
        String ktdb = "!@#$%^&*()_-+=<>,.?/\\|{}[]";
        for (int i = 0; i <= 1; i++) {
            maGen += ktdb.charAt(random.nextInt(ktdb.length()));
        }
        for (int i = 0; i <= 2; i++) {
            maGen += random.nextInt(10);
        }
        return maGen;
    }

    private HashMap<String, String> validate(CuaHang ch) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (ch.getDiaChi().trim().isEmpty()) {
            hashMap.put("stsDiaChi", "Địa chỉ còn trống");
        }
        if (ch.getTen().trim().isEmpty()) {
            hashMap.put("stsTen", "Ten còn trống");
        }
        return hashMap;
    }

}
