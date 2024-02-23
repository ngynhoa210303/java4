package com.fpt.poly.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "CuaHang")
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
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia;
}
