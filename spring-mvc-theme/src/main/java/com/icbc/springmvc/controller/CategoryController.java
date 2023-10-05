package com.icbc.springmvc.controller;

import com.icbc.springmvc.model.CategoryModel;
import com.icbc.springmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        // get data from service
        List<CategoryModel> data = service.gets();
        // send data to view
        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addCategory(){
        ModelAndView view = new ModelAndView("pages/category/add");
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveCategory(@ModelAttribute CategoryModel request){
        // call save from service
        service.save(request);
        // redirect to index
        return new ModelAndView("redirect:/category");
    }

    // edit method get
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/category/edit");
        CategoryModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/category");
        }

        // data send to view
        view.addObject("data", data);
        return view;
    }

    // update data
    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute CategoryModel request){
        // call save from service
        service.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/category/detail");
        // get data from service
        CategoryModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/category");
        }

        // send data to view
        view.addObject("data",data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        service.delete(id);
        return "redirect:/category";
    }
}
