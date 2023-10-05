package com.icbc.springmvc.repository;

import com.icbc.springmvc.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);

    boolean existsByName(String name;)
}
