package com.icbc.springjpa.service;

import com.icbc.springjpa.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> gets();
    Optional<CustomerModel> getById(Long id);
    void save(CustomerModel request);
    void update(CustomerModel request, Long id);
    void delete(Long id);
}
