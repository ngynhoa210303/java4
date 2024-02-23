package com.example.BTVN_Buoi5.service.impl;

import com.example.BTVN_Buoi5.service.LoginService;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkLogin(String usr, String psw) {
        boolean isCheck = false;
        if (usr.isEmpty() || psw.isEmpty()) {
            return isCheck;
        } else if (usr.equals("HangNT169") && psw.equals("123456")) {
            isCheck = true;
            return isCheck;
        } else {
            return isCheck;
        }
    }
}
