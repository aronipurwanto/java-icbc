package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class NamedConfiguration {
    @Primary
    @Bean(value = "fooFirst")
    public Foo foo1(){
        log.info("Create bean foo1");
        return new Foo();
    }

    @Bean(value = "fooSecond")
    public Foo foo2(){
        log.info("Create bean foo2");
        return new Foo();
    }
}
