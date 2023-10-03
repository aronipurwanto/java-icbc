package com.icbc.springdasar;

import com.icbc.springdasar.data.Bar;
import com.icbc.springdasar.data.Foo;
import com.icbc.springdasar.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class DependencyInjectionConfigurationTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(
                DependencyInjectionConfiguration.class
        );
    }

    @Test
    void testDI() {
        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean("bar",Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        // test
        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}