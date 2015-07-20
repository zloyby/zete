package by.zloy.interview;

import java.util.Map;

public class CountWords {

    public static final String text = "AB CD AB AB EF CD";

    public static void main(String[] args) {
        Map<String, Integer> result = CountWords.count();
        System.out.println(result);
        System.out.println("{AB=3, CD=2, EF=1}");
    }

    private static Map<String, Integer> count() {
        return null;
    }
}
