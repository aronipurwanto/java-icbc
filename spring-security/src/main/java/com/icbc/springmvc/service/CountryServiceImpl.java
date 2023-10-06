package com.icbc.springmvc.service;

import com.icbc.springmvc.entity.CountryEntity;
import com.icbc.springmvc.entity.DistrictEntity;
import com.icbc.springmvc.entity.ProvinceEntity;
import com.icbc.springmvc.entity.SubDistrictEntity;
import com.icbc.springmvc.repository.CountryRepo;
import com.icbc.springmvc.repository.DistrictRepo;
import com.icbc.springmvc.repository.ProvinceRepo;
import com.icbc.springmvc.repository.SubDistrictRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepo countryRepo;
    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final SubDistrictRepo subDistrictRepo;

    @Override
    public List<CountryEntity> getCountry() {
        return this.countryRepo.findAll();
    }

    @Override
    public List<ProvinceEntity> getProvince(Long countryId) {
        if(countryId == 0L){
            return Collections.emptyList();
        }

        return this.provinceRepo.findByCountryId(countryId);
    }

    @Override
    public List<DistrictEntity> getDistrict(Long provinceId) {
        if(provinceId == 0L){
            return Collections.emptyList();
        }
        return this.districtRepo.findByProvinceId(provinceId);
    }

    @Override
    public List<SubDistrictEntity> getSubDistrict(Long districtId) {
        if(districtId == 0L){
            return Collections.emptyList();
        }
        return this.subDistrictRepo.findByDistrictId(districtId);
    }
}
