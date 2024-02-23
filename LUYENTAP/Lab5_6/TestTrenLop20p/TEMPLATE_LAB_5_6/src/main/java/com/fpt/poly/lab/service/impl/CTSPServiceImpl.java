package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.CTSP;
import com.fpt.poly.lab.repository.CTSPRepository;
import com.fpt.poly.lab.service.CTSPService;

import java.util.List;

public class CTSPServiceImpl implements CTSPService {
    private CTSPRepository ctspRepository=new CTSPRepository();
    @Override
    public List<CTSP> getAll() {
        return ctspRepository.getAll();
    }
}
