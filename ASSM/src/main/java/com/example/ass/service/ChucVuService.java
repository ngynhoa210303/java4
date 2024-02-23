package com.example.ass.service;

import com.example.ass.entity.ChucVu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(UUID id);

    ChucVu getData(Map<String, String[]> cv);

    HashMap<String, String> addCV(ChucVu cv);

    HashMap<String, String> updateCV(ChucVu cv);

    void deleteCV(ChucVu cv);

}
