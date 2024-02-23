package com.example.BTVN_B3.BTVN_B3_fixCung.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class GiaoVien {
    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
