package com.icbc.springjpa.model;

import com.icbc.springjpa.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Long id;
    private Long accountNo;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // inject => dependency injection
    public CustomerModel(CustomerEntity entity){
        this.id = entity.getId();
        this.accountNo = entity.getAccountNo();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phoneNumber = entity.getPhoneNumber();
    }
}