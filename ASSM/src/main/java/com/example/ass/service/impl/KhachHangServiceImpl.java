package com.example.ass.service.impl;

import com.example.ass.entity.KhachHang;
import com.example.ass.repository.KhachHangRepository;
import com.example.ass.service.KhachHangService;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.getOne(id);
    }

    @Override
    public String genMaKH() {
        return khachHangRepository.genMaKhachHang();
    }

    @Override
    public KhachHang getData(Map<String, String[]> khmap,boolean createNew,String ma) {
        KhachHang kh = new KhachHang();
        try {
            if (createNew) {
                kh.setMa(khachHangRepository.genMaKhachHang());
            } else {
                kh.setMa(khmap.get("ma")[0]);
            }
            kh.setTen(khmap.get("ten")[0]);
            kh.setDiaChi(khmap.get("diaChi")[0]);
            kh.setTenDem(khmap.get("tenDem")[0]);
            kh.setSdt(khmap.get("sdt")[0]);
            kh.setHo(khmap.get("ho")[0]);
            kh.setThanhPho(khmap.get("thanhPho")[0]);
            kh.setQuocGia(khmap.get("quocGia")[0]);
            kh.setMatKhau(khmap.get("matKhau")[0]);
            kh.setThanhPho(khmap.get("thanhPho")[0]);
            String dateString = khmap.get("ngaySinh")[0];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateString);
            kh.setNgaySinh(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;

    }

    @Override
    public HashMap<String, String> addKH(KhachHang kh) {
        HashMap<String, String> hashMapAdd = validateForm(kh);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            khachHangRepository.add(kh);
            hashMapAdd.put("url", "/view/khachhang/khachhangs.jsp");
        } else {
            hashMapAdd.put("mess", "Add thất bại");
            hashMapAdd.put("url", "/view/khachhang/khachhangs.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> updateKH(KhachHang kh) {
        HashMap<String, String> hashMapAdd = validateForm(kh);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Update thành công");
            khachHangRepository.update(kh);
            hashMapAdd.put("url", "/view/khachhang/khachhangs.jsp");
        } else {
            hashMapAdd.put("mess", "Update thất bại");
            hashMapAdd.put("url", "/view/khachhang/view-update.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public void delKH(KhachHang kh) {
        khachHangRepository.delete(kh);
    }

    private HashMap<String, String> validateForm(KhachHang kh) {
        HashMap<String, String> hashMap = new HashMap<>();
//        if (kh.getMa().trim().isEmpty() || kh.getMa() == null) {
//            hashMap.put("stsMa", "Mã không được trống");
//        }
//        if (kh.getMa().length() > 20) {
//            hashMap.put("stsMa", "Mã không được phép vượt quá 20 ký tự");
//        }
        if (kh.getTen().trim().isEmpty() || kh.getTen() == null) {
            hashMap.put("stsTen", "Tên không được trống");
        }
        if (kh.getTen().length() > 30) {
            hashMap.put("stsTen", "Tên không được phép vượt quá 30 ký tự");
        }
        if (kh.getTenDem().trim().isEmpty() || kh.getTenDem() == null) {
            hashMap.put("stsTenDem", "Tên đệm không được trống");
        }
        if (kh.getTenDem().length() > 30) {
            hashMap.put("stsHo", "Họ không được phép vượt quá 30 ký tự");
        }
        if (kh.getHo().trim().isEmpty() || kh.getHo() == null) {
            hashMap.put("stsHo", "Họ không được trống");
        }
        if (kh.getHo().length() > 30) {
            hashMap.put("stsHo", "Họ không được phép vượt quá 30 ký tự");
        }
        if (Objects.isNull(kh.getNgaySinh())) {
            kh.setNgaySinh(new Date());
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                format.parse(format.format(kh.getNgaySinh()));
            } catch (ParseException e) {
                hashMap.put("stsNgaySinh", "Ngày sinh không đúng định dạng yyyy-MM-dd");
            }
        }
        if (kh.getNgaySinh().after(Calendar.getInstance().getTime())) {
            hashMap.put("stsNgaySinh", "Ngày sinh không thể ở trong tương lai");
        }
        if (kh.getSdt().trim().isEmpty() || kh.getSdt() == null) {
            hashMap.put("stsSDT", "Số điện thoại không được trống");
        }
        if (!kh.getSdt().matches("^(0\\d{9}|84\\d{9,10})$")) {
            hashMap.put("stsSDT", "Số điện thoại có 10 số bắt đầu bằng 0 có 11 số bắt đầu bằng 84");
        }
        if (kh.getDiaChi().trim().isEmpty() || kh.getDiaChi() == null) {
            hashMap.put("stsDiaChi1", "Địa chỉ không thể để trống");
        }
        if (kh.getDiaChi().length() > 100) {
            hashMap.put("stsDiaChi1", "Địa chỉ không thể vượt quá 100 ký tự");
        }
        if (kh.getThanhPho().trim().isEmpty() || kh.getThanhPho() == null) {
            hashMap.put("stsThanhPho1", "Thành phố không thể để trống");
        }
        if (kh.getQuocGia().trim().isEmpty() || kh.getThanhPho() == null) {
            hashMap.put("stsQuocGia1", "Quốc gia không thể để trống");
        }
        if (kh.getQuocGia().length() > 50) {
            hashMap.put("stsQuocGia1", "Tên quốc gia không vượt quá 50 ký tự");
        }
        if (kh.getMatKhau().trim().isEmpty() || kh.getMatKhau() == null) {
            hashMap.put("stsMatKhau", "Mật khẩu không để trống");
        }
        if (!kh.getMatKhau().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            hashMap.put("stsMatKhau", "Mật khẩu độ dài tối thiểu 8 ký tự và bao gồm ít nhất một chữ cái, một chữ số và một ký tự đặc biệt");
        }
        return hashMap;
    }
}
