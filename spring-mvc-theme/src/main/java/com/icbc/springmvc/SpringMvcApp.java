package com.icbc.springmvc;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.SortingStrategy;
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.GroupingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.model.IModel;
import org.thymeleaf.spring6.SpringTemplateEngine;

@SpringBootApplication
public class SpringMvcApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApp.class, args);
    }
}
