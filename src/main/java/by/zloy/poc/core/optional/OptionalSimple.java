package by.zloy.poc.core.optional;

import java.util.Optional;

public class OptionalSimple {
    public static void main(String[] args) {
        OptionalSimple.run();
    }

    private static void run() {
        System.out.println(Optional.ofNullable("1").orElse("false#1"));
        System.out.println(Optional.ofNullable("1"));
        System.out.println(Optional.ofNullable(null).orElse("false#2"));
        System.out.println(Optional.ofNullable(null));
    }
}

