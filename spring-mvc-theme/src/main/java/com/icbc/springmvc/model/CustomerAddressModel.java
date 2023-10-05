package com.icbc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressModel {
    private Long id;
    private String addressName;
    private String address;
    private String district;
    private String city;
    private String province;
    private String country;
}
