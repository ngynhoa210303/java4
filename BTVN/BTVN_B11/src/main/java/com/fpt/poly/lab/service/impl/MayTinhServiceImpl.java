package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.MayTinh;
import com.fpt.poly.lab.repository.MayTinhRepository;
import com.fpt.poly.lab.service.MaySinhService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class MayTinhServiceImpl implements MaySinhService {
    private final MayTinhRepository mayTinhRepository = new MayTinhRepository();

    @Override
    public List<MayTinh> getMayTinhList() {
        return mayTinhRepository.getMayTinhList();
    }

    @Override
    public List<MayTinh> getMayTinhListSort(String value) {
        return mayTinhRepository.getMayTinhListSort(value);
    }

    @Override
    public MayTinh getMayTinh(UUID ma) {
        return mayTinhRepository.getMayTinh(ma);
    }

    @Override
    public MayTinh getDataFrom(Map<String, String[]> mapMayTinh) {
        MayTinh mayTinh = new MayTinh();
        try {
            BeanUtils.populate(mayTinh, mapMayTinh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinh;
    }

    @Override
    public HashMap<String, String> addMayTinh(MayTinh mayTinh) {
        HashMap<String, String> hashMapAdd = valiFrom(mayTinh);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add máy tính thành công");
            mayTinhRepository.saveOrUpdate(mayTinh);
            hashMapAdd.put("url", "/trang-chu.jsp");
        } else {
            hashMapAdd.put("url", "/add-may-tinh.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateMayTinh(MayTinh mayTinh) {
        HashMap<String, String> hashMapUpdate = valiFrom(mayTinh);
        if (hashMapUpdate.isEmpty()) {
            mayTinhRepository.saveOrUpdate(mayTinh);
            hashMapUpdate.put("mess", "update máy tính thành công");
            hashMapUpdate.put("url", "/trang-chu.jsp");
        } else {
            hashMapUpdate.put("url", "/update-may-tinh.jsp");
        }
        return hashMapUpdate;
    }

    @Override
    public void removeMayTinh(MayTinh mayTinh) {
        mayTinhRepository.delete(mayTinh);
    }


    private HashMap<String, String> valiFrom(MayTinh mayTinh) {
        String ten = mayTinh.getTen();
        Float gia = mayTinh.getGia();
        String boNho = mayTinh.getBoNho();
        String moTa = mayTinh.getMoTa();
        HashMap<String, String> hashMapErr = new HashMap<>();

        if (ten.trim().equals("")) {
            hashMapErr.put("errTen", "Tên không được để trống");
        } else if (ten.length() > 100) {
            hashMapErr.put("errTen", "Tên vượt quá 100 ký tự");
        }
        if (boNho.trim().equals("")) {
            hashMapErr.put("errBoNho", "Bộ nhớ không được để trống");
        } else if (!(Pattern.compile("^\\d+GB$").matcher(boNho).matches())) {
            hashMapErr.put("errBoNho", "Bộ nhớ phải theo cấu trúc (Dung lượng + GB)");
        } else if (boNho.length() > 100) {
            hashMapErr.put("errBoNho", "Bộ nhớ vượt quá 100 ký tự");
        }
        if (moTa.trim().equals("")) {
            hashMapErr.put("errMoTa", "Mô tả không được để trống");
        } else if (moTa.length() > 100) {
            hashMapErr.put("errMoTa", "Mô tả vượt quá 100 ký tự");
        }
        if (gia <= 0) {
            hashMapErr.put("errGia", "Giá phải lớn hơn 0");
        }
        return hashMapErr;
    }

}
