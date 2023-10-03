package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateConfigurationTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
    }

    @Test
    void testDuplicate() {
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testPrimaryBean() {
        Foo foo = context.getBean(Foo.class);
        Assertions.assertNotNull(foo);

        Foo foo1 = context.getBean("foo1",Foo.class);
        Assertions.assertSame(foo, foo1);

        Foo foo2 = context.getBean("foo2",Foo.class);
        Assertions.assertNotSame(foo, foo2);
        Assertions.assertNotSame(foo1, foo2);
    }
}