package com.example.ass.service.impl;

import com.example.ass.entity.MauSac;
import com.example.ass.repository.MauSacRepository;
import com.example.ass.service.MauSacService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.getOne(id);
    }

    @Override
    public MauSac getData(Map<String, String[]> msmap) {
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms, msmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    @Override
    public HashMap<String, String> addCV(MauSac ms) {
        HashMap<String, String> hashMapAdd = validateForm(ms);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            mauSacRepository.add(ms);
            hashMapAdd.put("url", "/view/mausac/mausacs.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/mausac/mausacs.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateCV(MauSac ms) {
        HashMap<String, String> hashMapUpdate = validateForm(ms);
        if (hashMapUpdate.isEmpty()) {
            hashMapUpdate.put("mess", "Update thành công");
            mauSacRepository.update(ms);
            hashMapUpdate.put("url", "/view/mausac/mausacs.jsp");
        } else {
            hashMapUpdate.put("mess", "Update thất bại");
            hashMapUpdate.put("url", "/view/mausac/view-update.jsp");
        }
        return hashMapUpdate;
    }

    @Override
    public void deleteCV(MauSac ms) {
        mauSacRepository.delete(ms);
    }

    private HashMap<String, String> validateForm(MauSac ms) {
        String ma = ms.getMa();
        String ten = ms.getTen();
        HashMap<String, String> hashMapSTS = new HashMap<>();
        if (ma == null || ma.trim().isEmpty()) {
            hashMapSTS.put("stsMa", "Mã không được trống");
        }
        if (ma.length() > 20) {
            hashMapSTS.put("stsMa", "Mã tối đa 20 ký tự");
        }
        if (ten.trim().isEmpty()) {
            hashMapSTS.put("stsTen", "Tên không được trống");
        }
        if (ten.length() > 30) {
            hashMapSTS.put("stsTen", "Tên tối đa 30 ký tự");
        }
        return hashMapSTS;
    }

}
