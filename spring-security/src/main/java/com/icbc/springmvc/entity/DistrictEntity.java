package com.icbc.springmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PROVINCE_ID", insertable = false, updatable = false)
    private Long provinceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROVINCE_ID", nullable = false)
    private ProvinceEntity province;

    @Column(name = "DISTRICT_CODE", length = 10, nullable = false)
    private String code;

    @Column(name = "DISTRICT_NAME", length = 128, nullable = false)
    private String name;
}
