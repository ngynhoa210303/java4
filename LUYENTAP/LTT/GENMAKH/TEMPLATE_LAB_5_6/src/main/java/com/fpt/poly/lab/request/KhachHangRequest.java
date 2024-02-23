package com.fpt.poly.lab.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class KhachHangRequest {

    private String ma;

    private String ten;

    private String tenDem;

    private String ho;

    private String sdt;

    private String diaChi;


    public KhachHangRequest(String ma, String ten, String tenDem, String ho, String sdt, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }
}
