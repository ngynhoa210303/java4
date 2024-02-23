package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.ChucVu;
import com.fpt.poly.pe.entity.NhanVien;
import com.fpt.poly.pe.repository.NhanVienRepository;
import com.fpt.poly.pe.service.NhanVienService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    NhanVienRepository nvRep = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nvRep.getAll();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nvRep.getOne(id);
    }

    @Override
    public HashMap<String, String> add(NhanVien nv) {
        HashMap<String, String> hashMap=validate(nv);
        if (hashMap.isEmpty()){
            hashMap.put("mess","Thêm thành công");
            nvRep.add(nv);
        }else {
            hashMap.put("mess","Thêm thất bại");
        }
        return hashMap;
    }

    @Override
    public HashMap<String, String> update(NhanVien nv) {
        HashMap<String, String> hashMap=validate(nv);
        if (hashMap.isEmpty()){
            hashMap.put("mess","Update thành công");
            nvRep.update(nv);
        }else {
            hashMap.put("mess","Update thất bại");
        }
        return hashMap;
    }

    @Override
    public NhanVien getData(Map<String, String[]> mapNV) {
        NhanVien nv=new NhanVien();
        try{
            UUID chucVu=UUID.fromString((mapNV.get("chucVu")[0]));
            nv.setMa(mapNV.get("ma")[0]);
            nv.setHo(mapNV.get("ho")[0]);
            nv.setTen(mapNV.get("ten")[0]);
            nv.setGioiTinh(mapNV.get("gioiTinh")[0]);
            nv.setDiaChi(mapNV.get("diaChi")[0]);
            nv.setTenDem(mapNV.get("tenDem")[0]);
            nv.setMatKhau(mapNV.get("matKhau")[0]);
            nv.setTrangThai(Integer.valueOf(mapNV.get("trangThai[]")[0]));
            nv.setChucVu(new ChucVu(chucVu));
        }catch (Exception e){
            e.printStackTrace();
        }
        return nv;
    }

    @Override
    public void delete(NhanVien nv) {
        nvRep.delete(nv);
    }

    private HashMap<String,String> validate(NhanVien nv){
        HashMap<String,String> hashMap=new HashMap<>();
        if (nv.getMa().trim().isEmpty()){
            hashMap.put("stsMa","Mã trống");
        }
        return hashMap;
    }

}
