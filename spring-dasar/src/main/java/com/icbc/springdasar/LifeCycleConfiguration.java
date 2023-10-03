package com.icbc.springdasar;

import com.icbc.springdasar.data.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LifeCycleConfiguration {
    @Lazy
    @Bean
    public Connection connection(){
        return new Connection();
    }
}
