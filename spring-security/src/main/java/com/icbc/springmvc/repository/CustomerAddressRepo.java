package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddressEntity, Long> {
}
