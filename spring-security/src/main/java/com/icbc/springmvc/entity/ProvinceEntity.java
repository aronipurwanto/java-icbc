package com.icbc.springmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_province")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY_ID", insertable = false, updatable = false)
    private Long countryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private CountryEntity country;

    @Column(name = "PROVINCE_CODE", length = 20, nullable = false)
    private String code;

    @Column(name = "PROVINCE_NAME", length = 128, nullable = false)
    private String name;
}
