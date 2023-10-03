package com.icbc.springdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HelloConfigurationTest {
    @Test
    void testGetContext() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HelloConfiguration.class);

        Assertions.assertNotNull(context);
    }
}