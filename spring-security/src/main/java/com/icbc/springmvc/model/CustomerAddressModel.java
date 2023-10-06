package com.icbc.springmvc.model;

import com.icbc.springmvc.entity.CustomerAddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressModel {
    private Long id;
    private String addressName;
    private String address;
    private String district;
    private String subDistrict;
    private String province;
    private String country;

    public CustomerAddressModel(CustomerAddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
