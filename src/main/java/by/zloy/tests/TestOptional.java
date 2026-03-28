package by.zloy.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        TestOptional.run();
    }

    private static void run() {
        System.out.println(Optional.ofNullable("1").orElse("false#1"));
        System.out.println(Optional.ofNullable("1"));
        System.out.println(Optional.ofNullable(null).orElse("false#2"));
        System.out.println(Optional.ofNullable(null));

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        map.put("1", "22");
        map.put("11", "2");

        String s = Optional.ofNullable(map.get("1"))
                .filter(id -> Objects.equals(id, "2"))
                .orElseThrow(ArrayIndexOutOfBoundsException::new);
        System.out.println("!!! " + s);
    }
}

