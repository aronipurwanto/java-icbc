package com.icbc.springrest.controller;

import com.icbc.springrest.model.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public ResponseDto index(){
        ResponseDto result = new ResponseDto(
                200,
                "Success",
                "Welcome to Rest API");
        return result;
    }

    @GetMapping("/hello")
    public ResponseDto getParam(@RequestParam(value = "name") String name){
        ResponseDto result = new ResponseDto(
                200,
                "Success",
                "Hello "+ name
        );
        return result;
    }
}
