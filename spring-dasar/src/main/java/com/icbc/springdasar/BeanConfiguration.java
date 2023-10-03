package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import com.icbc.springdasar.data.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Foo foo(){
        Foo result = new Foo();
        return result;
    }

    @Bean
    public Person person(){
        return new Person();
    }
}
