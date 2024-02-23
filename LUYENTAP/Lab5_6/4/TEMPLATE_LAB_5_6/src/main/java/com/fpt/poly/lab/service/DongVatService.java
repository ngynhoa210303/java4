package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.DongVat;

import java.util.List;
import java.util.UUID;

public interface DongVatService {
    List<DongVat> getAll();

    DongVat getOne(UUID id);

    String add(DongVat dv);

    String update(DongVat dv);

    String delete(DongVat dv);

}
