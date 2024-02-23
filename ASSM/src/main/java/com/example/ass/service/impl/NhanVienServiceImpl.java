package com.example.ass.service.impl;

import com.example.ass.entity.ChucVu;
import com.example.ass.entity.CuaHang;
import com.example.ass.entity.NhanVien;
import com.example.ass.repository.NhanVienRepository;
import com.example.ass.service.NhanVienService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nvRep = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nvRep.getAll();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nvRep.getOne(id);
    }

    @Override
    public NhanVien getData(Map<String, String[]> cvmap) {
        NhanVien nv = new NhanVien();
        try {
            UUID chucVu = UUID.fromString(cvmap.get("chucVu")[0]);
            UUID cuaHang = UUID.fromString(cvmap.get("cuaHang")[0]);
            nv.setIdCH(new CuaHang(cuaHang));
            nv.setIdCV(new ChucVu(chucVu));
            nv.setTen(cvmap.get("ten")[0]);
            nv.setMa(cvmap.get("ma")[0]);
            nv.setSdt(cvmap.get("sdt")[0]);
            nv.setDiaChi(cvmap.get("diaChi")[0]);
            nv.setGioiTinh(cvmap.get("gioiTinh")[0]);
            nv.setTrangThai(Integer.valueOf(cvmap.get("trangThai")[0]));
            String dateString = cvmap.get("ngaySinh")[0];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateString);
            nv.setNgaySinh(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    @Override
    public HashMap<String, String> addNV(NhanVien nv) {
        HashMap<String, String> hashMapAdd = validate(nv);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Thêm thành công");
            nvRep.add(nv);
            hashMapAdd.put("url", "/view/nhanvien/nhanviens.jsp");
        } else {
            hashMapAdd.put("mess", "Thêm thành công");
            hashMapAdd.put("url", "/view/nhanvien/nhanviens.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateNV(NhanVien nv) {
        HashMap<String, String> hashMapAdd = validate(nv);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            nvRep.update(nv);
            hashMapAdd.put("url", "/view/nhanvien/nhanviens.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/nhanvien/view-update.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void deleteNV(NhanVien nv) {
        nvRep.delete(nv);
    }

    private HashMap<String, String> validate(NhanVien nv) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (nv.getTen().trim().isEmpty()) {
            hashMap.put("stsTen", "Tên không được trống");
        }
        if (nv.getNgaySinh() == null) {
            nv.setNgaySinh(new Date());
        }
        if (nv.getSdt().trim().isEmpty()) {
            hashMap.put("stsSDT", "SDT không để trống");
        }
        if (nv.getDiaChi().trim().isEmpty()) {
            hashMap.put("stsDiaChi", "Địa chỉ không để trống");
        }
        return hashMap;
    }
}
