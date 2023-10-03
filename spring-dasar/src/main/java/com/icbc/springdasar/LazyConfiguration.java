package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class LazyConfiguration {
    @Bean
    @Lazy
    public Foo foo(){
        log.info("Create new foo");
        return new Foo();
    }
}
