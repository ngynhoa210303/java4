package com.fpt.poly.lab.entity;

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

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Entity
@Table(name = "thuc_vat")
@Builder
@ToString
public class ThucVat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "loai")
    private String loai;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gioiTinh")
    private Boolean gioiTinh;
    @Column(name = "tuoi")
    private Integer tuoi;
    @Column(name = "khuVuc")
    private String khuVuc;

    public ThucVat(String loai, String ten, Boolean gioiTinh, Integer tuoi, String khuVuc) {
        this.loai = loai;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.khuVuc = khuVuc;
    }
}
