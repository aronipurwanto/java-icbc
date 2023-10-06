package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.DistrictEntity;
import com.icbc.springmvc.entity.SubDistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubDistrictRepo extends JpaRepository<SubDistrictEntity, Long> {
    List<SubDistrictEntity> findByDistrictId(Long provinceId);
}
