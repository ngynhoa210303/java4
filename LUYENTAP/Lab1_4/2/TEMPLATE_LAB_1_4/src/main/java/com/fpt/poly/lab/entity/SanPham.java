package com.fpt.poly.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    private int id;
    private String ma;
    private String ten;
    private String loai;
    private int gia;

}
