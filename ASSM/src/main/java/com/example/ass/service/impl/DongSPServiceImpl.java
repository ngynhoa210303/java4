package com.example.ass.service.impl;

import com.example.ass.entity.DongSP;
import com.example.ass.repository.DongSPRepository;
import com.example.ass.service.DongSPService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DongSPServiceImpl implements DongSPService {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public DongSP getOne(UUID id) {
        return dongSPRepository.getOne(id);
    }

    @Override
    public Boolean existsByMa(String ma) {
        return dongSPRepository.existsByMa(ma);
    }

    @Override
    public DongSP getData(Map<String, String[]> dongSPMap) {
        DongSP dongSP = new DongSP();
        try {
            dongSP.setMa(dongSPMap.get("ma")[0]);
            dongSP.setTen(dongSPMap.get("ten")[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }

    @Override
    public HashMap<String, String> addCV(DongSP dongSP) {
        HashMap<String, String> hashMapAdd = validateForm(dongSP);

        if (hashMapAdd.isEmpty()) {
            Boolean existsByMa = dongSPRepository.existsByMa(dongSP.getMa());
            if (existsByMa) {
                hashMapAdd.put("stsMa", "Mã trùng");
                hashMapAdd.put("mess", "Add thất bại");
                hashMapAdd.put("url", "/view/dongsp/dongsps.jsp");
            } else {
                hashMapAdd.put("mess", "Add thành công");
                dongSPRepository.add(dongSP);
                hashMapAdd.put("url", "/view/dongsp/dongsps.jsp");
            }
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/dongsp/dongsps.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateCV(DongSP dongSP) {
        HashMap<String, String> hashMapAdd = validateForm(dongSP);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            dongSPRepository.update(dongSP);
            hashMapAdd.put("url", "/view/dongsp/dongsps.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/dongsp/view-update.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void deleteCV(DongSP dongSP) {
        dongSPRepository.delete(dongSP);
    }

    private HashMap<String, String> validateForm(DongSP dongSP) {
        String ten = dongSP.getTen();
        HashMap<String, String> hashMapString = new HashMap<>();

        if (dongSP.getMa().trim().isEmpty() || dongSP.getMa() == null) {
            hashMapString.put("stsMa", "Mã không được trống");
        }
        if(existsByMa(dongSP.getMa())){
            hashMapString.put("stsMa", "Mã trùng");
        }

        if (dongSP.getMa().length() > 20) {
            hashMapString.put("stsMa", "Mã tối đa 20 ký tự");
        }
        if (ten.trim().isEmpty() || ten == null) {
            hashMapString.put("stsTen", "Tên không được trống");
        }
        if (ten.length() > 30) {
            hashMapString.put("stsTen", "Tên tối đa 30 ký tự");
        }
        return hashMapString;
    }
}
