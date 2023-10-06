package com.icbc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("pages/home/index");
    }
}
