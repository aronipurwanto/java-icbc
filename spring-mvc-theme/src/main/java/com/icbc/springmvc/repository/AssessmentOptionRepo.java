package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.AssessmentOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentOptionRepo extends JpaRepository<AssessmentOption, Long> {
}
