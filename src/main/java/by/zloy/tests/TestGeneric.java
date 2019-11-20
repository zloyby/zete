package by.zloy.tests;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {
        //Collection<? extends Number> c = new ArrayList<Number>();
        //c.add(new Integer(1)); // Compile time error

        List<Number> rawList = new ArrayList();
        rawList.add(new Integer(1));

        Getter<Integer> gI = new Getter<Integer>();
        System.out.println(gI.getIt(1));
        Getter<String> gS = new Getter<String>();
        System.out.println(gS.getIt("A"));
    }

    public static class Getter<T> {
        public <T> String getIt(T cl) {
            if (cl instanceof Integer) {
                return cl.toString();
            } else if (cl instanceof String) {
                return cl.toString();
            }
            return null;
        }
    }
}

