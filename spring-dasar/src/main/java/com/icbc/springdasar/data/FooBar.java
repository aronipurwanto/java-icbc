package com.icbc.springdasar.data;

import lombok.Data;

@Data
public class FooBar {
    private Foo foo;
    private Bar bar;

    // injection
    // via constructor
    public FooBar(Foo foo, Bar bar) {
        this.foo = foo;
        this.bar = bar;
    }
}
