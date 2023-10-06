package com.icbc.springmvc.controller;

import com.icbc.springmvc.entity.CountryEntity;
import com.icbc.springmvc.entity.DistrictEntity;
import com.icbc.springmvc.entity.ProvinceEntity;
import com.icbc.springmvc.entity.SubDistrictEntity;
import com.icbc.springmvc.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class ApiCountryController {
    private final CountryService countryService;

    @GetMapping()
    public List<CountryEntity> getCountry(){
        return this.countryService.getCountry();
    }

    @GetMapping("/province/{id}")
    public List<ProvinceEntity> getProvince(@PathVariable("id") Long id){
        return this.countryService.getProvince(id);
    }

    @GetMapping("/district/{id}")
    public List<DistrictEntity> getDistrict(@PathVariable("id") Long id){
        return this.countryService.getDistrict(id);
    }

    @GetMapping("/sub-district/{id}")
    public List<SubDistrictEntity> getSubDistrict(@PathVariable("id") Long id){
        return this.countryService.getSubDistrict(id);
    }
}
