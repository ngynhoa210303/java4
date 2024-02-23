package com.fpt.poly.lab.service;

import com.fpt.poly.lab.entity.MayTinh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface MaySinhService {
    List<MayTinh> getMayTinhList();

    List<MayTinh> getMayTinhListSort(String value);

    MayTinh getMayTinh(UUID ma);

    MayTinh getDataFrom(Map<String, String[]> mayTinh);

    HashMap<String, String> addMayTinh(MayTinh mayTinh);

    HashMap<String, String> updateMayTinh(MayTinh mayTinh);

    void removeMayTinh(MayTinh mayTinh);
}
