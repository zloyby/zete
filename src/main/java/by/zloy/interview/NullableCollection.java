package by.zloy.interview;

import java.util.*;

public class NullableCollection {

    static Map<String, Integer> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>();
    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        NullableCollection.run();
    }

    private static void run() {
        list.add(null);
        list.add(null);
        System.out.println(list.size());

        set.add(null);
        set.add(null);
        System.out.println(set.size());

        Object a1 = map.put(null, 1);
        Object a2 = map.put(null, 2);
        System.out.println(map.size());
        System.out.println(a1);
        System.out.println(a2);
    }
}
