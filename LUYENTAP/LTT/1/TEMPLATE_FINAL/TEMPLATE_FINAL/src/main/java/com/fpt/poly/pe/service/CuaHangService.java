package com.fpt.poly.pe.service;

import com.fpt.poly.pe.entity.CuaHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getOne(String id);

    void delete(CuaHang ch);

    CuaHang getData(Map<String,String[]>chMap);
    HashMap<String, String> add(CuaHang ch);

    HashMap<String, String> update(CuaHang ch);
}
