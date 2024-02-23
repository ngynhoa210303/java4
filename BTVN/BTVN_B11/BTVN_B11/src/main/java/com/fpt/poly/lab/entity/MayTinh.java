package com.fpt.poly.lab.entity;


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
import org.hibernate.annotations.Nationalized;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "may_tinh")
public class MayTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ma;

    @Column
    @Nationalized
    private String ten;

    @Column
    private Float gia;

    @Column(name = "bo_nho")
    @Nationalized
    private String boNho;

    @Column(name = "mau_sac")
    @Nationalized
    private String mauSac;

    @Column
    @Nationalized
    private String hang;

    @Column(name = "mieu_ta")
    @Nationalized
    private String moTa;

}
