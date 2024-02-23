package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.repository.KhachHangRepository;
import com.fpt.poly.pe.service.KhachHangService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khRepository.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> add(KhachHang kh) {
        kh.setMa(genMa());
        HashMap<String, String> hashMap = validate(kh);
        if (hashMap.isEmpty()) {
            hashMap.put("mess", "Add thanh cong");
            khRepository.addKH(kh);
        } else {
            hashMap.put("mess", "Add that bai");
        }
        return hashMap;
    }

    @Override
    public KhachHang getData(Map<String, String[]> hsm) {
        KhachHang kh = new KhachHang();
        try {
            kh.setTen(hsm.get("ten")[0]);
            kh.setThanhPho(hsm.get("thanhPho")[0]);
            kh.setDiaChi(hsm.get("diaChi")[0]);
            kh.setQuocGia(hsm.get("quocGia")[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    @Override
    public void delete(KhachHang kh) {
        khRepository.deleteKH(kh);
    }

    private HashMap<String, String> validate(KhachHang kh) {
        HashMap<String, String> hashMap = new HashMap<>();
//        if (kh.getDiaChi().trim().isEmpty()) {
//            hashMap.put("stsDiaChi", "Địa chỉ trống");
//        }
        if (kh.getTen().trim().isEmpty()) {
            hashMap.put("stsTen", "Ten trống");
        }
        if (kh.getThanhPho().trim().isEmpty()) {
            hashMap.put("stsThanhPho", "Thành phố trống");
        }
        return hashMap;
    }

    private String genMa() {
        String maGen = "";
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            maGen += (char) (rd.nextInt(29) + 'a');
        }
        for (int i = 0; i < 2; i++) {
            maGen += (char) (rd.nextInt(29) + 'A');
        }
        String ktdb = "~`!@#$%^&*()_+-=Ơ}ơ]\\|/<>,.?:;'";
        maGen += ktdb.charAt(rd.nextInt(ktdb.length()));
        maGen += rd.nextInt(10);
        return maGen;
    }
}
