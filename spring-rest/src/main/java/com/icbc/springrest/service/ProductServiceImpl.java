package com.icbc.springrest.service;

import com.icbc.springrest.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // productServiceImpl
public class ProductServiceImpl implements ProductService{
    @Override
    public List<ProductModel> getAll() {
        List<ProductModel> result = new ArrayList<>();
        result.add(new ProductModel(1,"Iphone 14 4G",14_000_000L));
        result.add(new ProductModel(2,"Samsung Galaxy S23 Ultra",18_000_000L));
        result.add(new ProductModel(3,"Samsung Galaxy S22 Ultra",10_000_000L));
        return result;
    }

    @Override
    public Optional<ProductModel> getById(int id) {
        if(id == 0){
            return Optional.empty();
        }

        ProductModel result = new ProductModel(1,"Iphone 14 4G",14_000_000L);
        return Optional.of(result);
    }
}
