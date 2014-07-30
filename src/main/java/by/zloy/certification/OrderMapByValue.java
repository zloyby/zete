package by.zloy.certification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OrderMapByValue {

    public static void main(String a[]) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Java", 20);
        map.put("Android", 20);
        map.put("Unix", 65);
        map.put("Mac", 25);
        map.put("C++", 30);
        map.put("Why this", 30);

        List<Entry<String, Integer>> list = sortByValue(map.entrySet());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static List<Entry<String, Integer>> sortByValue(Set<Entry<String, Integer>> set) {

        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        return list;
    }
}