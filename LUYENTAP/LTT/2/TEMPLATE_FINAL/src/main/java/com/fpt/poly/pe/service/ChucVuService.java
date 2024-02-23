package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(UUID id);
}
