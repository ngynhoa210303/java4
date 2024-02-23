package com.example.ass.service;

import com.example.ass.entity.ChiTietSP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();

    ChiTietSP getOne(UUID id);

    void delete(ChiTietSP ctsp);

    ChiTietSP getData(Map<String, String[]> khmap);

    HashMap<String, String> addCTSP(ChiTietSP chiTietSP);

    HashMap<String, String> updateCTSP(ChiTietSP chiTietSP);
}
