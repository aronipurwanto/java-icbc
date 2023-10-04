package com.icbc.springmvc.controller;

import com.icbc.springmvc.model.CustomerModel;
import com.icbc.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/customer/index");
        // get data from service
        List<CustomerModel> data = service.gets();
        // send data to view
        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addCustomer(){
        ModelAndView view = new ModelAndView("pages/customer/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute CustomerModel request){
        // call save from service
        service.save(request);
        // redirect to index
        return new ModelAndView("redirect:/customer");
    }

    // edit method get
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/customer");
        }

        // data send to view
        view.addObject("data", data);
        return view;
    }

    // update data
    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute CustomerModel request){
        // call save from service
        service.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/customer/detail");
        // get data from service
        CustomerModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/customer");
        }

        // send data to view
        view.addObject("data",data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        service.delete(id);
        return "redirect:/customer";
    }
}
