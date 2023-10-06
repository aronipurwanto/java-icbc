package com.icbc.springmvc.service;

import com.icbc.springmvc.model.AssessmentModel;

import java.util.List;
import java.util.Optional;

public interface AssessmentService {
    List<AssessmentModel> getAll();
    Optional<AssessmentModel> getById(Long id);
}
