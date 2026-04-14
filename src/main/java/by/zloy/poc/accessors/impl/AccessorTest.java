package by.zloy.poc.accessors.impl;

import by.zloy.poc.accessors.api.Exposed;

public class AccessorTest {
    public static void main(String[] args) {
        Accessor accessor = Accessor.getInstance();
        Exposed exposed = accessor.createExposed();
        accessor.sayHello(exposed);
    }
}
