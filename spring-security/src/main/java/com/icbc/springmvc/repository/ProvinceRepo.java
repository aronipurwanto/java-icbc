package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.CountryEntity;
import com.icbc.springmvc.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepo extends JpaRepository<ProvinceEntity, Long> {
    List<ProvinceEntity> findByCountryId(Long countryId);
}
