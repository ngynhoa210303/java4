package com.example.btvn9.service.impl;

import com.example.btvn9.entity.TaiKhoan;
import com.example.btvn9.repository.IUserRepository;
import com.example.btvn9.repository.impl.UserRepository;
import com.example.btvn9.service.UserService;

public class UserServiceImpl implements UserService {
    IUserRepository usRep=new UserRepository();
    @Override
    public TaiKhoan checkTonTai(String userName, String password) {
        return usRep.checkTonTai(userName,password);
    }
}
