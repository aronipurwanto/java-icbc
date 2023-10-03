package com.icbc.springdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CyclicConfigurationTest {
    private ApplicationContext context;

    @Test
    void testCyclic() {
        try {
            context = new AnnotationConfigApplicationContext(
                    CyclicConfiguration.class
            );
            Assertions.fail();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}