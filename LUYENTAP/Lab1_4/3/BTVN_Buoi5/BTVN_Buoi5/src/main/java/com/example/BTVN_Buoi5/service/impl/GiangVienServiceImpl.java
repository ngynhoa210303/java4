package com.example.BTVN_Buoi5.service.impl;

import com.example.BTVN_Buoi5.entity.GiangVien;
import com.example.BTVN_Buoi5.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    @Override
    public List<GiangVien> fakeData() {
        List<GiangVien> list = new ArrayList<>();
        list.add(new GiangVien("GV1", "HangNT", 18, "Nam Dinh"));
        list.add(new GiangVien("GV2", "HangNT", 18, "Nam Dinh"));
        list.add(new GiangVien("GV3", "HangNT", 18, "Nam Dinh"));
        list.add(new GiangVien("GV4", "HangNT", 18, "Nam Dinh"));
        list.add(new GiangVien("GV5", "HangNT", 18, "Nam Dinh"));
        return list;
    }

    @Override
    public void removeGV(List<GiangVien> listGV, int index) {
        listGV.remove(index);
    }

    @Override
    public boolean addGV(List<GiangVien> listGV, GiangVien gv) {
        boolean isAdd = false;
        if (gv.getMaGV().isEmpty() || gv.getQueQuan().isEmpty() || gv.getTenGV().isEmpty()) {
            return isAdd;
        } else if (!String.valueOf(gv.getTuoi()).matches("[0-9]+") || gv.getTuoi() < 25) {
            return isAdd;
        } else {
            listGV.add(gv);
            isAdd = true;
            return isAdd;
        }
    }

    @Override
    public boolean updateGV(List<GiangVien> listGV, int index, GiangVien gv) {
        boolean isUpdate = false;
        if (gv.getMaGV().isEmpty() || gv.getQueQuan().isEmpty() || gv.getTenGV().isEmpty()) {
            return isUpdate;
        } else if (!String.valueOf(gv.getTuoi()).matches("[0-9]+") || gv.getTuoi() < 25) {
            return isUpdate;
        } else {
            listGV.set(index, gv);
            isUpdate = true;
            return isUpdate;
        }
    }

    @Override
    public List<GiangVien> searchGV(List<GiangVien> listGV, String tenSearch, String min, String max) {
        List<GiangVien> listSearch = new ArrayList<>();
        if (tenSearch.isEmpty() && max.isEmpty() && min.isEmpty()) {
            return listGV;
        } else if (min.isEmpty() && max.isEmpty() && !tenSearch.isEmpty()) {
            for (GiangVien gv : listGV
            ) {
                if (gv.getTenGV().contains(tenSearch)) {
                    listSearch.add(gv);
                }
            }
        } else if (!min.isEmpty() && max.isEmpty() && !tenSearch.isEmpty()) {
            for (GiangVien gv : listGV
            ) {
                if (gv.getTenGV().contains(tenSearch) && gv.getTuoi() >= Integer.valueOf(min)) {
                    listSearch.add(gv);
                }
            }
        } else if (!min.isEmpty() && !max.isEmpty() && !tenSearch.isEmpty()) {
            for (GiangVien gv : listGV
            ) {
                if (gv.getTenGV().contains(tenSearch) && gv.getTuoi() >= Integer.valueOf(min) && gv.getTuoi() <= Integer.valueOf(max)) {
                    listSearch.add(gv);
                }
            }
        } else if (!min.isEmpty() && !max.isEmpty() && tenSearch.isEmpty()) {
            for (GiangVien gv : listGV
            ) {
                if (gv.getTuoi() >= Integer.valueOf(min) && gv.getTuoi() <= Integer.valueOf(max)) {
                    listSearch.add(gv);
                }
            }
        } else if (min.isEmpty() && !max.isEmpty() && !tenSearch.isEmpty()) {
            for (GiangVien gv : listGV
            ) {
                if (gv.getTenGV().contains(tenSearch) && gv.getTuoi() <= Integer.valueOf(max)) {
                    listSearch.add(gv);
                }
            }
        } else {
            return listGV;
        }
        return listSearch;
    }

    @Override
    public int getIndexByMaGV(List<GiangVien> listGV, String maGV) {
        int index = -2;
        for (int i = 0; i < listGV.size(); i++) {
            if (listGV.get(i).getMaGV().equals(maGV)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
