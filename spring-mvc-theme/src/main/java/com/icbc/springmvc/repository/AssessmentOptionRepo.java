package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.AssessmentOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentOptionRepo extends JpaRepository<AssessmentOptionEntity, Long> {
}
