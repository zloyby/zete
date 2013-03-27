package by.zloy.test;

import java.util.*;

public class TestWordsToMap {

    //    static Map<String, Integer> map = new TreeMap<String, Integer>();
//    static Map<String, Integer> map = new HashMap<String, Integer>();
    static Map<String, Integer> map = new HashMap();
    static Set<Integer> set = new HashSet<Integer>();
    static List<String> list = new ArrayList();

    //    static {
//        list.add("DFG");
//        list.add("ABC");
//        list.add("ABC");
//        list.add("ABC");
//        list.add("DFG");
//    }
    public static void main(String[] args) {
        TestWordsToMap.run();
    }

    private static void run() {
//        for (String s : list) {
//            Integer i = map.get(s) == null ? 0 : map.get(s) ;
//            map.put(s, ++i);
//        }

        set.add(null);
        set.add(null);
        list.add(null);
        list.add(null);
        map.put(null, 1);
        map.put(null, 2);

        System.out.println(map);
        System.out.println(list);
        System.out.println(set);
    }
}
