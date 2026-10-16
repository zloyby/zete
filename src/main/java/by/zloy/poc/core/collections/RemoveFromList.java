package by.zloy.poc.core.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene
 */
public class RemoveFromList {
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
