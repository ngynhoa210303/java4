package com.fpt.poly.pe.service.impl;

import com.fpt.poly.pe.entity.ChucVu;
import com.fpt.poly.pe.repository.ChucVuRepository;
import com.fpt.poly.pe.service.ChucVuService;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository cvRep=new ChucVuRepository();
    @Override
    public List<ChucVu> getAll() {
        return cvRep.getAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return cvRep.getOne(id);
    }
}
