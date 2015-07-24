package by.zloy.test.impl;

import by.zloy.test.api.Exposed;

public abstract class Accessor {

    private static Accessor instance;

    static Accessor getInstance() {
        Accessor a = instance;
        if (a != null) {
            return a;
        }

        return createInstance();
    }

    public static void setInstance(Accessor accessor) {
        if (instance != null) {
            throw new IllegalStateException(
                    "Accessor instance already set");
        }

        instance = accessor;
    }

    private static Accessor createInstance() {
        try {
            Class.forName(Exposed.class.getName(), true,
                    Exposed.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        return instance;
    }

    protected abstract Exposed createExposed();

    protected abstract void sayHello(Exposed exposed);
}