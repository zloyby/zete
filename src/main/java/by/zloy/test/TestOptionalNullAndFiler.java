package by.zloy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class TestOptionalNullAndFiler {
    public static void main(String[] args) {
        TestOptionalNullAndFiler.run();
    }

    private static void run() {

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
