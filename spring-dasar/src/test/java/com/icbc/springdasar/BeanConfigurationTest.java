package com.icbc.springdasar;

import com.icbc.springdasar.data.Foo;
import com.icbc.springdasar.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BeanConfigurationTest {
    @Test
    void testSingleton() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfiguration.class
        );

        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Assertions.assertSame(foo1, foo2);

        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        Assertions.assertSame(person1, person2);
    }
}