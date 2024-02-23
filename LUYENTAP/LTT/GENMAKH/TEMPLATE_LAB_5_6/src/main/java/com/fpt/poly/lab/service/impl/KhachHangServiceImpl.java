package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.repository.KhachHangRepository;
import com.fpt.poly.lab.request.KhachHangRequest;
import com.fpt.poly.lab.service.KhachHangService;
import com.microsoft.sqlserver.jdbc.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khRepo = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khRepo.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khRepo.getOne(id);
    }

    @Override
    public HashMap<String, String> add(KhachHangRequest request) {
        HashMap<String, String> lists = new HashMap<>();
        // Check validate
        if (request.getMa().isEmpty()) {

            lists.put("Ma_EMPTY", "Vui lòng nhập ma");
        }
        if (request.getTen().isEmpty()) {
            lists.put("TEN_EMPTY", "Vui lòng nhập ten");
        }
        if (request.getHo().isEmpty()) {
            lists.put("Ho_EMPTY", "Vui lòng nhập ho");
        }
        if (request.getTenDem().isEmpty()) {
            lists.put("Tendem_EMPTY", "Vui lòng nhập ten dem");
        }
        if (request.getSdt().isEmpty()) {
            lists.put("sdt_EMPTY", "Vui lòng nhập sdt");
        }
        if (request.getDiaChi().isEmpty()) {
            lists.put("diachi_EMPTY", "Vui lòng nhập dia chi");
        }
        // Khi thoả mãn validate
        if (lists.isEmpty()) {
            KhachHang kh = new KhachHang();
            kh.setTen(request.getTen());
            kh.setHo(request.getHo());
            kh.setTenDem(request.getTenDem());
            kh.setMa(request.getMa());
            kh.setSdt(request.getSdt());
            kh.setDiaChi(request.getDiaChi());
            khRepo.add(kh);
        }else{
            System.out.println("bugggggggggggggg");
        }

        return lists;
    }

    @Override
    public HashMap<String, String> update(KhachHangRequest request, UUID id) {
        HashMap<String, String> lists = new HashMap<>();
        KhachHang updatekh = khRepo.getOne(id);
        // Check validate
        if (request.getMa().isEmpty()) {

            lists.put("Ma_EMPTY", "Vui lòng nhập ma");
        }
        if (request.getTen().isEmpty()) {
            lists.put("TEN_EMPTY", "Vui lòng nhập ten");
        }
        if (request.getHo().isEmpty()) {
            lists.put("Ho_EMPTY", "Vui lòng nhập ho");
        }
        if (request.getTenDem().isEmpty()) {
            lists.put("Tendem_EMPTY", "Vui lòng nhập ten dem");
        }
        if (request.getSdt().isEmpty()) {
            lists.put("sdt_EMPTY", "Vui lòng nhập sdt");
        }
        if (request.getSdt().matches("^0\\d{9}$")) {
            lists.put("sdt_regex", "Sdt phai bat dau tu so 0 va phai du 10 so");
        }

        if (request.getDiaChi().isEmpty()) {
            lists.put("diachi_EMPTY", "Vui lòng nhập dia chi");
        }
        // Khi thoả mãn validate
        if (lists.isEmpty()) {
            updatekh.setTen(request.getTen());
            updatekh.setHo(request.getHo());
            updatekh.setTenDem(request.getTenDem());
            updatekh.setMa(request.getMa());
            updatekh.setSdt(request.getSdt());
            updatekh.setDiaChi(request.getDiaChi());
            khRepo.update(updatekh);
        }

        return lists;
    }


    @Override
    public boolean delete(UUID id) {
        KhachHang kh = khRepo.getOne(id);
        return khRepo.delete(kh);
    }

    @Override
    public List<KhachHang> search(String ten) {
        return khRepo.search(ten);
    }

    @Override
    public int genMaKhachHang() {
        return khRepo.genMaKhachHang();
    }


}
