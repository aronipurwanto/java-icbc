package com.icbc.springdasar;

import com.icbc.springdasar.data.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class LifeCycleConfigurationTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(
                LifeCycleConfiguration.class
        );
    }

    @AfterEach
    void tearDown() {
        context.close();
    }

    @Test
    void testLifeCycle() {
        Connection connection = context.getBean(Connection.class);

        Assertions.assertNotNull(connection);
    }
}