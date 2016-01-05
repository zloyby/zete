package by.zloy.test;

@SuppressWarnings("ALL")
public class TestFormatter {

    public static void main(String[] args) {
        Long l1 = 0111L;
        Long l2 = 1111L;
        Long l3 = null;

        System.out.println(String.format("%08d", l1));
        System.out.println(String.format("%08d", l2));
        System.out.println(String.format("%08d", l3));
    }
}
