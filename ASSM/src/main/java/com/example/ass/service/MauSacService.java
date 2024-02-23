package com.example.ass.service;


import com.example.ass.entity.MauSac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac getOne(UUID id);

    MauSac getData(Map<String, String[]> msmap);

    HashMap<String, String> addCV(MauSac ms);

    HashMap<String, String> updateCV(MauSac ms);

    void deleteCV(MauSac ms);
}
