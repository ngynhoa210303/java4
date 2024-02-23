package com.poly.hangnt169.B3_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt169
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinhVien {
//    mssv-String,ten-String,tuoi-int,diaChi-String,gioiTinh-boolean
    private String mssv;
    private String ten;
    private int tuoi;
    private String diaChi;
    private boolean gioiTinh;

}
