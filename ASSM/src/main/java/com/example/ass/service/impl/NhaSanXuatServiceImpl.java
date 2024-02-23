package com.example.ass.service.impl;

import com.example.ass.entity.DongSP;
import com.example.ass.entity.NhaSanXuat;
import com.example.ass.repository.NhaSanXuatRepository;
import com.example.ass.service.NhaSanXuatService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    private NhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.getAll();
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return nhaSanXuatRepository.getOne(id);
    }

    @Override
    public NhaSanXuat getData(Map<String, String[]> nsxMap) {
        NhaSanXuat nsx = new NhaSanXuat();
        try {
            BeanUtils.populate(nsx, nsxMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    @Override
    public HashMap<String, String> add(NhaSanXuat nsx) {
        HashMap<String, String> hashAdd = validateForm(nsx);
        if (hashAdd.isEmpty()) {
            hashAdd.put("mess", "Thêm thành công");
            nhaSanXuatRepository.add(nsx);
            hashAdd.put("url", "/view/nsx/nsxs.jsp");
        } else {
            hashAdd.put("mess", "Thêm thất bại");
            hashAdd.put("url", "/view/nsx/nsxs.jsp");
        }
        return hashAdd;
    }

    @Override
    public HashMap<String, String> update(NhaSanXuat nsx) {
        HashMap<String, String> hashAdd = validateForm(nsx);
        if (hashAdd.isEmpty()) {
            hashAdd.put("mess", "Sửa thành công");
            nhaSanXuatRepository.update(nsx);
            hashAdd.put("url", "/view/nsx/nsxs.jsp");
        } else {
            hashAdd.put("mess", "Sửa thất bại");
            hashAdd.put("url", "/view/nsx/view-update.jsp");
        }
        return hashAdd;
    }

    @Override
    public void delete(NhaSanXuat nsx) {
        nhaSanXuatRepository.delete(nsx);
    }

    private HashMap<String, String> validateForm(NhaSanXuat nsx) {
        HashMap<String, String> hashMapStr = new HashMap<>();
        if (nsx.getMa().trim().isEmpty() || nsx.getMa() == null) {
            hashMapStr.put("stsMa", "Mã không thể trống");
        }
        if (nsx.getMa().length() > 20) {
            hashMapStr.put("stsMa", "Mã không thể vượt quá 20 ký tự");
        }
        if (nsx.getTen().trim().isEmpty() || nsx.getTen() == null) {
            hashMapStr.put("stsTen", "Tên không thể trống");
        }
        if (nsx.getMa().length() > 30) {
            hashMapStr.put("stsTen", "Tên không thể >30 ký tự");
        }
        return hashMapStr;
    }


}
