package com.example.BTVN_Buoi5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GiangVien {
    String maGV;
    String tenGV;
    int tuoi;
    String queQuan;
}
