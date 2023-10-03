package com.icbc.springjpa.service;

import com.icbc.springjpa.entity.CustomerEntity;
import com.icbc.springjpa.model.CustomerModel;
import com.icbc.springjpa.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CustomerModel> gets() {
        List<CustomerEntity> result = this.customerRepo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream()
                .map(CustomerModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        CustomerEntity entity = this.customerRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        CustomerModel result = new CustomerModel(entity);
        return Optional.of(result);
    }

    @Override
    public void save(CustomerModel request) {
        if(this.customerRepo.existsByAccountNo(request.getAccountNo())){
            log.warn("Save customer failed, error: account number with {} is exist", request.getAccountNo());
            return;
        }

        // proses create object
        CustomerEntity entity = new CustomerEntity();
        // copy value property to entity
        BeanUtils.copyProperties(request, entity);
        // try save
        try {
            this.customerRepo.save(entity);
            log.info("Save customer success");
        }catch (Exception e){
            log.warn("Save customer failed, error: {}", e.getMessage());
        }
    }

    @Override
    public void update(CustomerModel request, Long id) {
        CustomerEntity entity = this.customerRepo.findById(id)
                .orElse(null);
        if(entity == null){
            return;
        }

        // copy property
        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        // try save
        try {
            this.customerRepo.save(entity);
            log.info("Update customer success");
        }catch (Exception e){
            log.warn("Update customer failed, error: {}", e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        CustomerEntity entity = this.customerRepo.findById(id).orElse(null);
        if(entity == null){
            return;
        }
        // try save
        try {
            this.customerRepo.delete(entity);
            log.info("Delete customer success");
        }catch (Exception e){
            log.warn("Delete customer failed, error: {}", e.getMessage());
        }
    }
}
