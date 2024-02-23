package com.example.ass.service.impl;

import com.example.ass.entity.ChucVu;
import com.example.ass.repository.ChucVuRepository;
import com.example.ass.service.ChucVuService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository cvRep = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return cvRep.getAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return cvRep.getOne(id);
    }

    @Override
    public ChucVu getData(Map<String, String[]> cvmap) {
        ChucVu cv = new ChucVu();
        try {
            BeanUtils.populate(cv, cvmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    @Override
    public HashMap<String, String> addCV(ChucVu cv) {
        HashMap<String, String> hashMapAdd = validateForm(cv);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            cvRep.add(cv);
            hashMapAdd.put("url", "/view/chucvu/chucvus.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/chucvu/chucvus.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateCV(ChucVu cv) {
        HashMap<String, String> hashMapAdd = validateForm(cv);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            cvRep.update(cv);
            hashMapAdd.put("url", "/view/chucvu/chucvus.jsp");
        } else {
            hashMapAdd.put("url", "/view/chucvu/view-update-cvu.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void deleteCV(ChucVu cv) {
        cvRep.delete(cv);
    }

    private HashMap<String, String> validateForm(ChucVu cv) {
        String ma = cv.getMa();
        String ten = cv.getTen();
        HashMap<String, String> hashMapSTS = new HashMap<>();
        if (ma == null || ma.trim().isEmpty()) {
            hashMapSTS.put("stsMa", "Mã không được trống");
        }
        if (ma.length() > 20) {
            hashMapSTS.put("stsMa", "Mã tối đa 20 ký tự");
        }
        if (ten == null || ten.trim().isEmpty()) {
            hashMapSTS.put("stsTen", "Tên không được trống");
        }
        if (ten.length() > 50) {
            hashMapSTS.put("stsTen", "Tên tối đa 50 ký tự");
        }
        return hashMapSTS;
    }

}
