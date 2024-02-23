package com.example.ass.service;

import com.example.ass.entity.NhaSanXuat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(UUID id);

    NhaSanXuat getData(Map<String, String[]> nsxMap);

    HashMap<String, String> add(NhaSanXuat nsx);

    HashMap<String, String> update(NhaSanXuat nsx);

    void delete(NhaSanXuat nsx);
}
