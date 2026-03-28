package by.zloy.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountWords {

    public static final String text = "CD AB AB EF AB CD";

    public static void main(String[] args) {
        Map<String, Integer> result = CountWords.count();
        System.out.println(result);
        System.out.println("{CD=2, AB=3, EF=1}");
    }

    private static Map<String, Integer> count() {
        Map<String, Integer> p = new LinkedHashMap<String, Integer>();

        StringTokenizer st = new StringTokenizer(text, " ");
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            Integer i = p.get(s);
            p.put(s, i != null ? ++i : 1);
        }

        return p;
    }
}
