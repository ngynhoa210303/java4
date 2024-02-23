package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.GiangVien;
import com.fpt.poly.lab.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    @Override
    public List<GiangVien> fakeData() {
       List<GiangVien>listGV=new ArrayList<>();
       listGV.add(new GiangVien("1","Ngyn Hoa",19,true,"Thái Bình"));
       listGV.add(new GiangVien("2","Ngyn Ha",20,false,"Thái Bình"));
       listGV.add(new GiangVien("3","Ngyn Aa",19,true,"Thái Bình"));
       listGV.add(new GiangVien("4","Ngyn Đa",39,false,"Thái Bình"));
       listGV.add(new GiangVien("5","Ngyn Oa",19,true,"Thái Bình"));
       return listGV;
    }

    @Override
    public void removeGiangVien(List<GiangVien> lists, String id) {
        int viTiTimDc=findGV(lists, id);
        lists.remove(viTiTimDc);
    }

    @Override
    public GiangVien findGiangVienByID(List<GiangVien> lists, String id) {
        int viTriTimDc=findGV(lists, id);
        return lists.get(viTriTimDc);
    }

    @Override
    public List<GiangVien> listSearch(List<GiangVien> lists, String ten) {
        List<GiangVien> listSearch = new ArrayList<>();
        for (GiangVien x : lists) {
            if (x.getTen().contains(ten)) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public List<GiangVien> listNu(List<GiangVien> lists, Boolean gioiTinh) {
        List<GiangVien> listSearch = new ArrayList<>();
        for (GiangVien x : lists) {
            if (x.isGioiTinh()==true) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public boolean updateGV(String id, List<GiangVien> lists, GiangVien giangVien) {
        int index = findGV(lists,id);
        if (index == -1) {
            return false;
        }
        // update
        lists.set(index, giangVien);
        return true;
    }

    @Override
    public GiangVien getOne(List<GiangVien> list, int index) {
        return list.get(index);
    }

    @Override
    public void removeGV(List<GiangVien> lists, int index) {
        lists.remove(index);
    }

    private int findGV(List<GiangVien>lts,String id){
       for (int i=0;i< lts.size();i++){
           if(lts.get(i).getId().equalsIgnoreCase(id)){
               return i;
           }
        }
        return -1;
    }
}
