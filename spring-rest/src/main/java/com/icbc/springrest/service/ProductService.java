package com.icbc.springrest.service;

import com.icbc.springrest.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductModel> getAll();
    Optional<ProductModel> getById(int id);
}
