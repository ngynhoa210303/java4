package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.NhanVien;
import com.fpt.poly.pe.repository.NhanVienRepository;
import com.fpt.poly.pe.service.NhanVienService;
import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    NhanVienRepository nvRepo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nvRepo.getAll();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nvRepo.getOne(id);
    }

    @Override
    public HashMap<String, String> add(NhanVien nv) {
        HashMap<String, String> hsm = validate(nv);
        if (hsm.isEmpty()) {
            hsm.put("mess", "Add thành công");
            nv.setMa(nvRepo.genMaNV());
            nvRepo.add(nv);
            hsm.put("url", "/fe/view/nhanviens.jsp");
        } else {
            hsm.put("mess", "Add thất bại");
            hsm.put("url", "/fe/view/nhanviens.jsp");
        }
        return hsm;
    }

    @Override
    public NhanVien getData(Map<String, String[]> nvMap) {
        NhanVien nv = new NhanVien();
        try {
            BeanUtils.populate(nv, nvMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    @Override
    public void delete(NhanVien nv) {
        nvRepo.delete(nv);
    }

    @Override
    public String genMaNV() {
        return nvRepo.genMaNV();
    }

    private HashMap<String, String> validate(NhanVien nv) {
        HashMap<String, String> hsm = new HashMap<>();
//        if (nv.getMa().trim().isEmpty()) {
//            hsm.put("stsMa", "Ma khong trong");
//        }
        if (nv.getTen().trim().isEmpty()) {
            hsm.put("stsTen", "Ten khong trong");
        }
        if (nv.getDiaChi().trim().isEmpty()) {
            hsm.put("stsDiaChi", "Dia chi khong trong");
        }
        return hsm;
    }
}
