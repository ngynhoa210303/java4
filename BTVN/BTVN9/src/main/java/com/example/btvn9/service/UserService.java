package com.example.btvn9.service;

import com.example.btvn9.entity.TaiKhoan;

public interface UserService {
    TaiKhoan checkTonTai(String userName, String password);
}
