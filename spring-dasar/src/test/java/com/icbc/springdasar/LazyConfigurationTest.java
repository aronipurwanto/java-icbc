package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class LazyConfigurationTest {
    private ApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(
                LazyConfiguration.class
        );
    }

    @Test
    void testLazy() {
        Foo foo = context.getBean(Foo.class);
    }
}