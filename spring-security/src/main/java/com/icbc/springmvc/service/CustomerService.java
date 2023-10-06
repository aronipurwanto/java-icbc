package com.icbc.springmvc.service;

import com.icbc.springmvc.model.CustomerAddressModel;
import com.icbc.springmvc.model.CustomerModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<CustomerModel> getPage();
    List<CustomerModel> gets();
    Optional<CustomerModel> getById(Long id);
    void save(CustomerModel request);
    void saveAddress(CustomerAddressModel request);
    void update(CustomerModel request, Long id);
    void delete(Long id);
}
