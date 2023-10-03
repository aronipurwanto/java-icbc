package com.icbc.springdasar.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DatabaseTest {

    @Test
    void getInstance() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();
        Assertions.assertSame(database1, database2);

        Person person1 = new Person();
        Person person2 = new Person();
        Assertions.assertNotSame(person1, person2);
    }
}