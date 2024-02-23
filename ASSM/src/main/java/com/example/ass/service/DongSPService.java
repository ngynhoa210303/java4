package com.example.ass.service;

import com.example.ass.entity.DongSP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DongSPService {
    List<DongSP> getAll();

    DongSP getOne(UUID id);
    Boolean existsByMa(String ma);

    DongSP getData(Map<String, String[]> dongSPMap);

    HashMap<String, String> addCV(DongSP dongSP);

    HashMap<String, String> updateCV(DongSP dongSP);

    void deleteCV(DongSP dongSP);
}
