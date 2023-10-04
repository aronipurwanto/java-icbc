package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepo extends JpaRepository<AssessmentEntity, Long> {
}
