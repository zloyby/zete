package by.zloy.test;

import java.util.BitSet;

public class TestBitMaps {


    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    public static void main(String[] args) {
        TestBitMaps testBitMaps = new TestBitMaps();

        testBitMaps.result(true, true, false);
    }

    @SuppressWarnings("SameParameterValue")
    private void result(boolean b1, boolean b2, boolean b3) {
        BitSet flags = new BitSet(3);
        // set
        flags.set(FIRST, b1);
        flags.set(SECOND, b2);
        flags.set(THIRD, b3);
        // flip : if (flags.contains(Flag.FIRST)) {flags.remove(Flag.FIRST);} else {flags.add(Flag.FIRST);}
        flags.flip(FIRST);
        flags.flip(THIRD);
        // clear
        flags.clear(SECOND);
        // get
        System.out.println(flags.get(FIRST));//f
        System.out.println(flags.get(SECOND));//f
        System.out.println(flags.get(THIRD));//t
    }
}
