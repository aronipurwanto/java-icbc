package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.DistrictEntity;
import com.icbc.springmvc.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepo extends JpaRepository<DistrictEntity, Long> {
    Optional<DistrictEntity> findByCode(String code);
    List<DistrictEntity> findByProvinceId(Long provinceId);
}
