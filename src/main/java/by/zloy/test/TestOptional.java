package by.zloy.test;

import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {

        System.out.println(Optional.ofNullable("1").orElse("false#1"));
        System.out.println(Optional.ofNullable("1"));
        System.out.println(Optional.ofNullable(null).orElse("false#2"));
        System.out.println(Optional.ofNullable(null));


    }
}

