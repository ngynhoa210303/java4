package com.fpt.poly.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiangVien {
    private String id;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
