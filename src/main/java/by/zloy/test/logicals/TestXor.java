package by.zloy.test.logicals;

public class TestXor {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3};
        System.out.println(singleNumber(arr));

    }

    static public int singleNumber(int[] arr) {
        int x = 0;

        for (int a : arr) {
            x = x ^ a;
        }

        return x;
    }
}
