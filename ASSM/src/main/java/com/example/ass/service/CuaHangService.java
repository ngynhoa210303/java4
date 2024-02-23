package com.example.ass.service;

import com.example.ass.entity.CuaHang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getOne(UUID id);

    CuaHang getData(Map<String, String[]> chMap);

    HashMap<String, String> add(CuaHang ch);

    HashMap<String, String> update(CuaHang ch);

    void delete(CuaHang ch);
}
