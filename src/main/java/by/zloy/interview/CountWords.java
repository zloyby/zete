package by.zloy.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountWords {

    public static final String text = "CD AB AB EF AB CD";

    public static void main(String[] args) {
        Map<String, Integer> result = CountWords.count(text);
        System.out.println(result);
        System.out.println("{CD=2, AB=3, EF=1}");
    }

    public static Map<String, Integer> count(String text) {
        Map<String, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(text, " ");
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            map.compute(s, (k, i) -> i != null ? i + 1 : 1);
        }
        return map;
    }
}
