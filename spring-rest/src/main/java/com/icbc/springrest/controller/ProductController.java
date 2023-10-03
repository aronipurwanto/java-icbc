package com.icbc.springrest.controller;

import com.icbc.springrest.model.ProductModel;
import com.icbc.springrest.model.ResponseDto;
import com.icbc.springrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController { // productController bean
    private final ProductService service;

    // constructor
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseDto getAll(){
        List<ProductModel> products = service.getAll();
        ResponseDto result = new ResponseDto(
                200,
                "Success",
                products
                );
        return result;
    }

    @GetMapping("/{id}")
    public ResponseDto getById(@PathVariable("id") int id){
        Optional<ProductModel> product = service.getById(id);

        ResponseDto result = new ResponseDto(200,"Success", product);
        return result;
    }

    @PostMapping // add new product
    public ResponseDto postData(@RequestBody ProductModel request){
        ResponseDto result = new ResponseDto(200,"Success", request);
        return result;
    }

    @PatchMapping("/{id}") // update
    public ResponseDto patchData(@PathVariable("id") int id,
                                 @RequestBody ProductModel request){
        // get by Id
        // update dengan request
        // save
        request.setId(id);
        ResponseDto result = new ResponseDto(200,"Success", request);
        return result;
    }
}
