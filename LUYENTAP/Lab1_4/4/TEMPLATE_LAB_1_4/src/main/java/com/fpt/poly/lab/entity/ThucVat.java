package com.fpt.poly.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThucVat {
    private Integer id;
    private String loaiCay;
    private String ten;
    private Integer tuoi;
    private boolean gioiTinh;
    private String khuVuc;

}
