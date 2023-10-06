package com.icbc.springmvc.model;

import com.icbc.springmvc.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
    private Long id;
    private String name;

    public CategoryModel(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
