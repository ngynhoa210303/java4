package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.repository.KhachHangRepository;
import com.fpt.poly.pe.service.KhachHangService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    private List<KhachHang> list = new ArrayList<>();
    private int liss = list.size();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public KhachHang getOne(String ten) {
        return khachHangRepository.getOne(ten);
    }

    @Override
    public KhachHang getData(Map<String, String[]> stringMap) {
        KhachHang ch = new KhachHang();
        try {
            ch.setTen(stringMap.get("ten")[0]);
            ch.setDiaChi(stringMap.get("diaChi")[0]);
            ch.setSdt(stringMap.get("sdt")[0]);
            ch.setMatKhau(stringMap.get("matKhau")[0]);
            String dateString = stringMap.get("ngaySinh")[0];
            ch.setNgaySinh(Date.valueOf(dateString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    @Override
    public HashMap<String, String> add(KhachHang khachHang) {
        khachHang.setMa(generateMa());
        HashMap<String, String> hashMapAdd = validateFoem(khachHang);
        if (hashMapAdd.isEmpty()) {
            hashMapAdd.put("mess", "Add thành công");
            khachHangRepository.add(khachHang);
            hashMapAdd.put("url", "/fe/view/trang-chu.jsp");
        } else {
            hashMapAdd.put("url", "/fe/view/add.jsp");
        }
        return hashMapAdd;
    }

    @Override
    public HashMap<String, String> update(KhachHang khachHang) {
        HashMap<String, String> hashMapUpdate = validateFoem(khachHang);
        if (hashMapUpdate.isEmpty()) {
            hashMapUpdate.put("mess", "Update thành công");
            khachHangRepository.update(khachHang);
            hashMapUpdate.put("url", "/fe/view/trang-chu.jsp");
        } else {
            hashMapUpdate.put("url", "/fe/view/update.jsp");
        }
        return hashMapUpdate;
    }

    @Override
    public void delete(KhachHang khachHang) {
        khachHangRepository.delete(khachHang);
    }

    private HashMap<String, String> validateFoem(KhachHang khachHang) {
        String ma = khachHang.getMa();
        String ten = khachHang.getTen();
        String sdt = khachHang.getSdt();
        Date ngaySinh = khachHang.getNgaySinh();
        String diaChi = khachHang.getDiaChi();
        String matKhau = khachHang.getMatKhau();
        HashMap<String, String> hashMapErr = new HashMap<>();

        if (ma.trim().isEmpty()) {
            hashMapErr.put("errMa", "Mã không được để trống");
        }
        if (ten.trim().isEmpty()) {
            hashMapErr.put("errTen", "Tên không được để trống");
        }
        if (sdt.trim().isEmpty()) {
            hashMapErr.put("errSDT", "SDT không được để trống");
        } else if (sdt.length() != 10) {
            hashMapErr.put("errSDT", "SDT phải có 10 số");
        } else if (sdt.startsWith("1") || sdt.startsWith("2") || sdt.startsWith("3") || sdt.startsWith("4") || sdt.startsWith("5")
                || sdt.startsWith("6") || sdt.startsWith("7") || sdt.startsWith("8") || sdt.startsWith("9")) {
            hashMapErr.put("errSDT", "SDT phải bắt đầu bằng số 0");
        }
        if (diaChi.trim().isEmpty()) {
            hashMapErr.put("errDiaChi", "Địa chỉ không được để trống");
        }
        if (matKhau.trim().isEmpty()) {
            hashMapErr.put("errMatKhau", "Mật khẩu không được để trống");
        }
        return hashMapErr;
    }

//    private String generateMa() {
////        String ma = "";
////        Random random = new Random();
////
////        // Tạo 2 ký tự thường
////        for (int i = 0; i < 2; i++) {
////            ma += (char) (random.nextInt(26) + 'a');
////        }
////
////        // Tạo 3 ký tự hoa
////        for (int i = 0; i < 3; i++) {
////            ma += (char) (random.nextInt(26) + 'A');
////        }
////
////        // Tạo 1 ký tự đặc biệt
////        String specialChars = "!@#$%^&*()_-+=<>,.?/\\|{}[]";
////        ma += specialChars.charAt(random.nextInt(specialChars.length()));
////
////        // Tạo 1 số
////        ma += random.nextInt(10);
////
////        return ma;
//    }

    //private String generateMa() {
//    String ma = RandomStringUtils.random(2, true, false)  // 2 ký tự thường
//            + RandomStringUtils.random(3, true, true)   // 3 ký tự hoa
//            + RandomStringUtils.random(1, "!@#$%^&*()_-+=<>,.?/\\|{}[]")  // 1 ký tự đặc biệt
//            + RandomStringUtils.randomNumeric(1);        // 1 số
//    return ma;
//}
    private String generateMa() {
        String maGen = "";
        Random rd = new Random();
        for (int i = 0; i <= 2; i++) {
            maGen += (char) (rd.nextInt(26) + 'a');
        }
        for (int i = 0; i <= 3; i++) {
            maGen += (char) (rd.nextInt(26) + 'A');
        }
        for (int i = 0; i <= 2; i++) {
            maGen += rd.nextInt(10);
        }
        String ktdb = "~!@#$%^&*()_+Ơ{}|-=??\\/[]<>,.`";
        for (int i = 0; i <= 2; i++) {
            maGen += ktdb.charAt(rd.nextInt(ktdb.length()));
        }
        //        // Tạo 1 ký tự đặc biệt
//        String specialChars = "!@#$%^&*()_-+=<>,.?/\\|{}[]";
//        ma += specialChars.charAt(random.nextInt(specialChars.length()));
//
//        // Tạo 1 số
//        ma += random.nextInt(10);
//
        return maGen;
    }
}
