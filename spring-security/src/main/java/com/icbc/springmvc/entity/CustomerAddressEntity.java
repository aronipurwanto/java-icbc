package com.icbc.springmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_customer_address")
public class CustomerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ADDR_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @Column(name = "ADDRESS_NAME", length = 128)
    private String addressName;

    @Column(name = "ADDRESS", length = 128)
    private String address;

    @Column(name = "DISTRICT", length = 128)
    private String district;

    @Column(name = "SUB_DISTRICT", length = 128)
    private String subDistrict;

    @Column(name = "PROVINCE", length = 128)
    private String province;

    @Column(name = "COUNTRY", length = 128)
    private String country;
}
