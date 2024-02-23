package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.ThucVat;
import com.fpt.poly.lab.service.ThucVatService;

import java.util.ArrayList;
import java.util.List;

public class ThucVatServiceImpl implements ThucVatService {

    @Override
    public List<ThucVat> listData() {
        List<ThucVat> listData = new ArrayList<>();
        listData.add(new ThucVat(1, "Loai1", "Cay1", 12, true, "KV1"));
        listData.add(new ThucVat(2, "Loai2", "Cay2", 11, false, "KV2"));
        listData.add(new ThucVat(3, "Loai3", "Cay3", 12, true, "KV3"));
        listData.add(new ThucVat(4, "Loai4", "Cay4", 20, false, "KV4"));
        listData.add(new ThucVat(5, "Loai5", "Cay5", 12, true, "KV5"));
        return listData;
    }

    @Override
    public boolean addTV(List<ThucVat> lists, ThucVat tv) {
        boolean add = false;
        if (tv.getTen().isEmpty() || tv.getKhuVuc().isEmpty() || tv.getLoaiCay().isEmpty()) {
            return add;
        } else {
            lists.add(tv);
            add = true;
            return add;
        }
    }

    @Override
    public boolean updateTV(List<ThucVat> lists, int index, ThucVat tv) {
        boolean update = false;
        if (tv.getTen().isEmpty() || tv.getKhuVuc().isEmpty() || tv.getLoaiCay().isEmpty()) {
            return update;
        } else {
            lists.set(index, tv);
            update = true;
            return update;
        }
    }

    @Override
    public ThucVat getOne(List<ThucVat> lists, int index) {
        return lists.get(index);
    }

    @Override
    public void remove(List<ThucVat> lists, int index) {
        lists.remove(index);
    }

    @Override
    public List<ThucVat> search(List<ThucVat> lists, String tenSearch, String min, String max) {
        List<ThucVat> listSearch = new ArrayList<>();

        for (ThucVat gv : lists) {
            boolean isTenMatch = tenSearch.isEmpty() || gv.getTen().contains(tenSearch);
            boolean isMinMatch = min.isEmpty() || gv.getTuoi() >= Integer.valueOf(min);
            boolean isMaxMatch = max.isEmpty() || gv.getTuoi() <= Integer.valueOf(max);

            if (isTenMatch && isMinMatch && isMaxMatch) {
                listSearch.add(gv);
            }
        }

        return listSearch;
    }

}

