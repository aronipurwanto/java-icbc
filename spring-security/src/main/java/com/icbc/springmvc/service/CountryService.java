package com.icbc.springmvc.service;

import com.icbc.springmvc.entity.CountryEntity;
import com.icbc.springmvc.entity.DistrictEntity;
import com.icbc.springmvc.entity.ProvinceEntity;
import com.icbc.springmvc.entity.SubDistrictEntity;

import java.util.List;

public interface CountryService {
    List<CountryEntity> getCountry();
    List<ProvinceEntity> getProvince(Long countryId);
    List<DistrictEntity> getDistrict(Long provinceId);
    List<SubDistrictEntity> getSubDistrict(Long districtId);
}
