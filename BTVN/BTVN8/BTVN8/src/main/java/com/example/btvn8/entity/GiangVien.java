package com.example.btvn8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "giang_vien")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiangVien {
    @Id
    @Column(name = "mssv")
    private String mssv;
    @Column(name="ten")
    private String ten;
    @Column(name = "tuoi")
    private Long tuoi;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
    @Column(name = "que_quan")
    private String queQuan;
}
