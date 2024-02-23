package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.CuaHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getOne(UUID ma);

    CuaHang getData(Map<String, String[]> chmap);

    HashMap<String, String> addCH(CuaHang ch);

    void delete(CuaHang ch);
}
