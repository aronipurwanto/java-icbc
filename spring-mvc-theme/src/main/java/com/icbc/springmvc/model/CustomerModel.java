package com.icbc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private int id;
    private Long accountNo;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}