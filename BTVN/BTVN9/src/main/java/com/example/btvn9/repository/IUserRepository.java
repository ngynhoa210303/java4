package com.example.btvn9.repository;

import com.example.btvn9.entity.TaiKhoan;

public interface IUserRepository {
    TaiKhoan checkTonTai(String userName,String password);
}
