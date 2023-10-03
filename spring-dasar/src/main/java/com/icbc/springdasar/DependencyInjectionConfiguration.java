package com.icbc.springdasar;

import com.icbc.springdasar.data.Bar;
import com.icbc.springdasar.data.Foo;
import com.icbc.springdasar.data.FooBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class DependencyInjectionConfiguration {
    @Bean
    @Primary
    @DependsOn(value = "bar")
    public Foo foo(){
        log.info("Create new foo");
        return new Foo();
    }

    @Bean
    public Foo fooBaru(){
        log.info("Create new fooBaru");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create new bar");
        return new Bar();
    }

    @Bean
    public Bar barBaru(){
        log.info("Create new barBaru");
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier(value = "foo") Foo foo,
                         @Qualifier(value = "bar") Bar bar){
        log.info("Create new fooBar");
        return new FooBar(foo, bar);
    }
}
