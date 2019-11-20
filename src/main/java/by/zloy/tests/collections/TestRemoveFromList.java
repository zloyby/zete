package by.zloy.tests.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene
 */
public class TestRemoveFromList {
    public static void main(String[] args) {
        List<String> s = new ArrayList<String>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");

        String o = s.get(1);
        s.remove(o);

        System.out.println(o);
        System.out.println(s.size());
    }
}
