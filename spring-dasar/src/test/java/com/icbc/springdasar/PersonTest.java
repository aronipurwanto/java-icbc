package com.icbc.springdasar;

import com.icbc.springdasar.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void testNewObject() {
        Person person = new Person(1, "Roni", "roni@gmail.com");
        Assertions.assertNotNull(person);

        Person person2 = new Person(2, "Monica", "monica@gmail.com");
        Assertions.assertNotNull(person2);

        Person person3 = new Person();
        person3.setId(3);
        person3.setName("Hermawan");
        person3.setEmail("hermawan@gmail.com");
        Assertions.assertNotNull(person2);
    }
}