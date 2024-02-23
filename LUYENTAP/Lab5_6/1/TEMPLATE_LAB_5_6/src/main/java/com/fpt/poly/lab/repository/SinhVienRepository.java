package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.service.SinhVienService;

import java.util.List;
import java.util.UUID;

public interface SinhVienRepository {
    List<SinhVien> getAll();

    SinhVien getOne(UUID id);

    Boolean addSV(SinhVien sv);

    Boolean removeSV(SinhVien sv);

    Boolean updateSV(SinhVien sv);

//    List<SinhVien> listSearch(String ten);
    List<SinhVien> listSearch2DK(String ten,Boolean gioiTinh);

}
