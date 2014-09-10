package by.zloy.interview;

public class Overloading {
    public void test(float param) {
        System.out.println("float: " + param);
    }

    public void test(double param) {
        System.out.println("double: " + param);
    }

    public void test(long param) {
        System.out.println("long: " + param);
    }

    public void test(byte param) {
        System.out.println("byte: " + param);
    }

    public void test(short param) {
        System.out.println("short: " + param);
    }

    public static void main(String[] args) {
        Overloading ot = new Overloading();
        ot.test(999999999);
    }
}
