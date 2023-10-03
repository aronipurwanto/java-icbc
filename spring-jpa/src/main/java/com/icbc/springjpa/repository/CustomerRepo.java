package com.icbc.springjpa.repository;

import com.icbc.springjpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
    boolean existsByAccountNo(Long accountNo);
}
