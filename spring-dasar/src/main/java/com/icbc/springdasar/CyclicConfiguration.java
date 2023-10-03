package com.icbc.springdasar;

import com.icbc.springdasar.cyclic.CyclicSatu;
import com.icbc.springdasar.cyclic.CyclicDua;
import com.icbc.springdasar.cyclic.CyclicTiga;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CyclicConfiguration {
    @Bean
    public CyclicSatu cyclicSatu(CyclicDua cyclicDua){
        return new CyclicSatu(cyclicDua);
    }

    @Bean
    public CyclicDua cyclicDua(CyclicTiga cyclicTiga){
        return new CyclicDua(cyclicTiga);
    }

    @Bean
    public CyclicTiga cyclicTiga(CyclicSatu cyclicSatu){
        return new CyclicTiga(cyclicSatu);
    }
}
