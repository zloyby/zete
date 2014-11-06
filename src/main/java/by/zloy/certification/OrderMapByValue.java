package by.zloy.certification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List listResult = sortByName(list);
        System.out.println(listResult);
        //2-d level
        Map mapResult1 = sortByKey(map);
        System.out.println(mapResult1);
        //3-d level
        Map mapResult2 = sortByValueAndAfterByKey(map);
        System.out.println(mapResult2);

    }

    private static List sortByName(List<String> list) {
        return list;
    }

    private static Map sortByKey(Map<String, Integer> map) {
        return map;
    }

    private static Map sortByValueAndAfterByKey(Map<String, Integer> map) {
        return map;
    }

}