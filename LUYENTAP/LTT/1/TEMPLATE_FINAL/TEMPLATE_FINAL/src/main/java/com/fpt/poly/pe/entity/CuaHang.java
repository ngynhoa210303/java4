package com.fpt.poly.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "CuaHang")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "DiaChi")
    private String diaChi;

    public CuaHang(String ma, String ten, String thanhPho, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.thanhPho = thanhPho;
        this.diaChi = diaChi;
    }
}
