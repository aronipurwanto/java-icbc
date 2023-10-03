package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {
    @Bean
    @Scope(value = "prototype")
    public Foo foo(){
        log.info("Create new foo");
        return new Foo();
    }
}
