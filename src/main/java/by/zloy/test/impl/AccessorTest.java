package by.zloy.test.impl;

import by.zloy.test.api.Exposed;

public class AccessorTest {
    public static void main(String[] args) {
        Accessor accessor = Accessor.getInstance();
        Exposed exposed = accessor.createExposed();
        accessor.sayHello(exposed);
    }
}
