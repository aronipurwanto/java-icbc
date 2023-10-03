package com.icbc.springjpa.repository;

import com.icbc.springjpa.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddressEntity, Long> {
}
