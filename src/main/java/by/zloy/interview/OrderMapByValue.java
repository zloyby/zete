package by.zloy.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderMapByValue {

    public static void main(String a[]) {

        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Android");
        list.add("Unix");
        list.add("Mac");
        list.add("C++");
        list.add("Why this");

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Java", 20);
        map.put("Android", 20);
        map.put("Unix", 65);
        map.put("Mac", 25);
        map.put("C++", 30);
        map.put("Why this", 30);

        //1-t level
        List<String> listResult = sortByName(list);
        System.out.println(listResult);
        //2-d level
        Map<String, Integer> mapResult1 = sortByKey(map);
        System.out.println(mapResult1);
        //3-d level
        Map<String, Integer> mapResult2 = sortByValueAndAfterByKey(map);
        System.out.println(mapResult2);

    }

    private static List<String> sortByName(List<String> list) {
        Collections.sort(list);
        return list;
    }

    private static Map<String, Integer> sortByKey(Map<String, Integer> map) {
        return new TreeMap<String, Integer>(map);
    }

    private static Map<String, Integer> sortByValueAndAfterByKey(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = sortByValues(map);
        return sortedMap;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortByValues(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new LinkedList<Map.Entry<K, V>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int comparedByValue = o1.getValue().compareTo(o2.getValue());
                int comparedByKey = o1.getKey().compareTo(o2.getKey());
                return (comparedByValue == 0) ? comparedByKey : comparedByValue;
            }
        });

        Map<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}